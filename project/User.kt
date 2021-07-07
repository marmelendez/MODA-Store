package project

import kotlin.collections.List as List1

class User (val idUser: String){
    var name = ""
    var email = ""
    var password = ""
    var address = ""
    var shoppingCart = mutableListOf<Product>()
    var orders = mutableListOf<String>()
    var devolutions = mutableListOf<String>()

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

    @JvmName("setName1")
    private fun setName(name: String) {
        this.name = name
    }

    @JvmName("setEmail1")
    private fun setEmail(email: String) {
        this.email = email
    }

    @JvmName("setPassword1")
    private fun setPassword(password: String) {
        this.password = password
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

    fun signIn () {
        print("---------- Sign In ----------\n- Please enter your name:")
        setName(readLine().toString())
        print("- Now your email:")
        setEmail(readLine().toString())
        print("- Lastly your password:")
        setPassword(readLine().toString())//Encriptar contraseña
        print("Welcome! now you have an account")
    }

    fun searchProduct(store: Store) {
        var flag = true
        while (flag){
            var count = 0
            print("\n---------- MODA Store | SEARCH ----------\nHi there, which product are you looking for? ")
            var productName = readLine().toString()
            val result = store.getCatalogProduct().filter { it.getName().toLowerCase().contains(productName.toLowerCase())}
            count = result.size
            val text = if(count > 0) " We found ${count} results :)" else " Sorry no match found :("
            println(text)
            result.forEach { println("\t${it.getIdProduct()} \t${it.getName()}") }

            print("\n-> Do you want to ...?" +
                    "\n  1) Search another product" +
                    "\n  2) Select a product " +
                    "\n  3) Return to menu please" +
                    "\n -> Choose an option: ")
            if (readLine().toString() != "1") flag = false
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
}
