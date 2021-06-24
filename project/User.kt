package project

import kotlin.collections.List as List1

class User (val idUser: String){
    var name = ""
    var email = ""
    var password = ""
    var address = ""
    var shoppingCart = mutableListOf<String>()
    var orders = mutableListOf<String>()
    var devolutions = mutableListOf<String>()

    @JvmName("getAddress1")
    fun getAddress(): String {
        return this.address
    }

    @JvmName("getShoppingCart1")
    fun getShoppingCart(): List1<String> {
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

    fun set(address: String) {
        this.address = address
    }

    fun signIn () {
        print("---------- Sign In ----------\n- Please enter your name:")
        this.name = readLine().toString()
        print("- Now your email:")
        this.email = readLine().toString()
        print("- Lastly your password:")
        this.password = readLine().toString() //Encriptar contraseña
        print("Welcome! now you have an account")
    }

    fun searchProduct() {
        var flag = true
        while (flag){
            print("Hi there, which product are you looking for? ")
            var product = readLine().toString()
            if (false){ //this.catalogue.contains(product)
                println("We found the next results :)")
                flag = false
            }else {
                print("Sorry no match found, wanna try with something else? y/n")
                var answer = readLine().toString()
                if (answer == "n") flag = false
            }
        }
    }

    fun addToCart(idProduct: String) {
        this.shoppingCart.add(idProduct)
    }

    fun removeFromCart(idProduct: String) {
        this.shoppingCart.remove(idProduct)

    }

    fun makePurchase(idOrder: String) {
        this.orders.add(idOrder)
    }

    fun makeRefund(idRefund: String) {
        this.devolutions.add(idRefund)
    }

    fun checkOrderStatus(idOrder: String) {
        
    }

    fun checkDevolutionStatus(idRefund: String) {

    }

}