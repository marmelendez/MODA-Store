package project

import kotlin.collections.List as List1

open class User (open val idUser: String){
    private var address = ""
    private var shoppingCart = mutableListOf<Product>()
    private var orders = mutableListOf<String>()
    private var devolutions = mutableListOf<String>()


    @JvmName("getAddress1")
    fun getAddress(): String {
        return this.address
    }

    @JvmName("getShoppingCart1")
    private fun getShoppingCart(): List1<Product> {
        return this.shoppingCart
    }

    @JvmName("getOrders1")
    fun getOrders(): List1<String> {
        return this.orders
    }

    @JvmName("getDevolutions1")
    fun getDevolutions(): List1<String>{
        return this.devolutions
    }


    @JvmName("setAddress1")
    private fun setAddress(address: String) {
        this.address = address
    }

    fun displayShoppingCart() {
        println("---------- Shopping Cart ----------")
        getShoppingCart().forEach() {
            println(it.getName())
        }
    }

    fun signIn (store: Store) {
        //validar que no esten ya registrados y que sean validos
        print("---------- MODA Store | SIGN IN ----------\n\n-> Please enter your username: ")
        var name = readLine().toString()
        var error1 = "--- Enter a valid username (start with a letter, can contain letters and numbers and at least 6 characters): "
        var error2 = "--- The given username is already registered: "
        while (!validate(name, error1,Form.validateUsername(name)) || !validate(name, error2,store.isInListOfUsersUsername(name))){
            name = readLine().toString()
        }

        print("\n-> Now your email: ")
        var email = readLine().toString()
        error1 = "--- Enter a valid email (ends with @domain.com): "
        error2 = "--- The given email is already registered: "
        while (!validate(email, error1,Form.validateEmail(email)) || !validate(email, error2,store.isInListOfUsersEmail(email))){
            email = readLine().toString()
        }

        print("\n-> And your password, we recommend you this one ${Form.passwordGenerator()}: ")
        var password = readLine().toString()
        error1 = "--- Enter a valid password (minimum length: 8,can contain letters, numbers or . / _): "
        while (!validate(password, error1,Form.validatePassword(password))){
            password = readLine().toString()
        }

        //crear usuario registrado
        val newUser = RegisteredUser(idUser, name, email, password)
        store.addUser(newUser)

        //Agregar corutina
        println("\nWelcome ${newUser.getName()}! now you have an account")
    }

    fun validate(data: String, error: String, funValidate: Boolean): Boolean {
        if (!funValidate) {
            print(error)
            return false
        }
        return true
    }

    fun searchProduct(store: Store) {
        var flag = true
        var option: String
        while (flag){
            print("\n---------- MODA Store | SEARCH ----------\nHi there, which product are you looking for? ")

            var productName = readLine().toString()

            val result = store.catalogProduct.filter { it.getName().toLowerCase().contains(productName.toLowerCase())}
            val text = if(result.isNotEmpty()) " We found ${result.size} results :)" else " Sorry no match found :("
            println("${text}\n\tID \tName")
            result.forEach { println("\t${it.getIdProduct()} \t${it.getName()}") }

            print("\nDo you want to ...?" +
                    "\n  1) Search another product" +
                    "\n  2) Select a product " +
                    "\n  3) Return to menu please" +
                    "\n\n-> Choose an option: ")
            option = readLine().toString()
            if (option!= "1") flag = false
            if (option == "2") {
                print("   -> Please enter the product ID: ")
                var id = readLine().toString()
                var selectedProduct = store.catalogProduct.filter { id == it.getIdProduct().toString() }
                try {
                    selectProduct(selectedProduct[0])
                } catch(e: Exception) {
                    println("Sorry, couldn't find a product with the ${id} id :(")
                }
            }
        }
    }

    fun selectProduct(product: Product) {
        println("\n---------- MODA Store | ${product.getName()} ----------" +
                "\nID: ${product.getIdProduct()}" +
                "\nPrice: ${product.getPrice()}" +
                "\nColor: ${product.getColor()}" +
                "\nCategory: ${product.getCategory().getName()}" +
                "\nSize: ${product.getQuantity().map { it.key }}")
        print("\nDo you want to ...?" +
                "\n  1) Add to cart" +
                "\n  2) Add to favorites " +
                "\n  3) Return to menu please" +
                "\n\n-> Choose an option: ")
        when (readLine().toString()) {
            "1" -> addToCart(product)
            "2" -> println("agregar a favoritos")
        }
    }

    fun addToCart(product: Product) {
        println("The product ${product.getName()} has been added to your cart")
        this.shoppingCart.add(product)
    }

    fun removeFromCart(product: Product) {
        println("The product ${product.getName()} has been removed to your cart")
        this.shoppingCart.remove(product)
    }

    fun makePurchase() {
        println("---------- Purchase ----------")
        var total = 0F
        shoppingCart.forEach() {
            println(" - ${it.getName()}\t $ ${it.getPrice()}")
            total += it.getPrice()
        }
        var iva = total * 0.16F
        println("Subtotal: $ ${total}\nIVA: ${iva}\nTotal a pagar: ${total + iva}")
    }

    fun makeRefund(idRefund: String) {
        this.devolutions.add(idRefund)
    }

    //implementar funcion de si el usuario esta registrado
}