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
        this.shoppingCart.remove(product)
    }

    fun makePurchase(idOrder: String) {
        this.orders.add(idOrder)
    }

    fun makeRefund(idRefund: String) {
        this.devolutions.add(idRefund)
    }
}
