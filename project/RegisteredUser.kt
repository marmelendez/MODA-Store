package project;

import kotlin.collections.List as List1

class RegisteredUser(
        override val idUser: String,
        private val name: String,
        private val email: String,
        private var password: String): User(idUser){

        private var shoppingCart = mutableListOf<Product>()
        private var orders = mutableListOf<String>()
        private var devolutions = mutableListOf<String>()
        private var favorites = mutableListOf<Product>()
        private var address = ""


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
        fun getDevolutions(): List1<String> {
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

        fun getName(): String {
                return this.name
        }

        fun getEmail(): String {
                return this.email
        }

        fun getPassword(): String {
                return this.password
        }

        fun logIn(store: Store) : RegisteredUser? { //Boolean
                print("\n---------- MODA Store | LOG IN ----------\nUsername: ")
                var name = readLine().toString()

                while (store.getUser(name) == null) {
                        print("Sorry the username ${name} is not registered. Try with another one: ")
                        name = readLine().toString()
                }

                val regUser = store.getUser(name)
                print("Password: ")
                var password : String = readLine().toString()

                if (regUser != null) {
                        while (regUser.getPassword() != password) {
                                print("Incorrect password: ")
                                password = readLine().toString()
                        }
                        println("Welcome again $name to MODA Store")
                } else {
                        println("Sorry couldn't find an account with the username ${name}")
                }

                //println("Welcome again $name to MODA Store")
                //return false
                return regUser
        }

        fun logOut() : Boolean {
                print("\n---------- MODA Store | LOG OUT ----------")
                return true
        }

        fun profile(store: Store, user: RegisteredUser){
                println("---------- MODA Store | PROFILE ----------")
                println("Welcome again ${user.name} to MODA Store")

                println("ID: ${user.idUser}")
                println("Nombre: ${user.name}")
                println("Email: ${user.email}")
                println("Password: ${user.password}")
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

        fun addToFavorite(product: Product) {
                println("The product ${product.getName()} has been added to your favorite list")
                this.favorites.add(product)
        }
}

/*
Registered User
- profile: configuracion
- compras: id, carrito, total, fecha
- agregar a carrito
 */

