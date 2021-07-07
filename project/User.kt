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
            print("\n---------- Search ----------\nHi there, which product are you looking for? ")
            var productName = readLine().toString()
            store.getProductNames().forEach(){
                if (it.toLowerCase().contains(productName.toLowerCase())){ //this.catalogue.contains(product)
                    count ++
                }
            }
            if (count > 0){
                print(" We found ${count} results :)\n -> Do you want to search another product? y/n: ")
            } else{
                print("Sorry no match found :(\n -> Do you want to search another product? y/n: ")
            }
            if (readLine().toString() == "n") flag = false
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

    var user = true

    fun makePurchase() {
        println("---------- Purchase ----------")
        //Usuario con cuenta
        if(user == true) {
            var total = 0F
            println("Purchase Details")
            shoppingCart.forEach() {
                println(" - ${it.getName()}\t $ ${it.getPrice()}")
                total += it.getPrice()
            }
            val iva = total * 0.16F
            val totalPrice = iva + total
            println("Subtotal: $ ${total}\nIVA: ${iva}\nTotal to pay: ${totalPrice}")

            if(address == "") {
                println("---------- Alert ----------")
                println("You must add an address")
                getAddress()
            } else {
                //Para aumentar idOrder
                val numOrder = 1001
                //Para Fecha
                val now = Date()
                val formatDate = SimpleDateFormat("yy.MM.dd")
                val date = formatDate.format(now)


                println("Confirm Purchase? y/n ")
                val conf = readLine().toString()
                if (conf == "y") {
                    val orders = Order(
                        numOrder,
                        totalPrice,
                        address,
                        date
                    )
                    numOrder + 1

                    println("What do you want to do now? ")
                    println("1 Menu")
                    println("2 Devolutions")
                    println("3 Exit")
                    val opcion = readLine().toString()
                    when(opcion) {
                        "1" -> displayMenu()
                        "2" -> displayShoppingCart()
                        "3" -> println("Goodbye, Come back soon")
                        else -> println("Invalid Option")
                    }

                } else {
                    displayMenu()
                }
            }


        //Usuario sin cuenta
        } else {
            println("Ups, You dont have an account. You want to register? y/n ")
            if(readLine().toString() == "y") {
                signIn()
            } else {
                println("Ok, You will continue as a guest")
            }
        }
    }

    fun makeRefund(idRefund: String) {
        this.devolutions.add(idRefund)
    }
}
