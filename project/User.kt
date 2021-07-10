package project

abstract class User {
    val name: String = ""
    var email: String = ""
    var password: String = ""
    var shoppingCart = mutableListOf<Product>()
    var orders = mutableListOf<String>()
    var devolutions = mutableListOf<String>()

    abstract fun signIn(store: Store)
    abstract fun logIn()
    abstract fun logOut()
}