package project;

import kotlin.collections.List

class RegisteredUser(
        override val idUser: String,
        private val name: String,
        private val email: String,
        private var password: String): User(idUser){

        private var shoppingCart = mutableListOf<Product>()
        private var orders = mutableListOf<String>()
        private var favorites = mutableListOf<Product>()
        private var address = ""

        fun getName(): String {
                return this.name
        }

        fun getEmail(): String {
                return this.email
        }

        fun getPassword(): String {
                return this.password
        }

        @JvmName("getAddress1")
        fun getAddress(): String {
                return this.address
        }

        @JvmName("setAddress1")
        private fun setAddress(address: String) {
                this.address = address
        }

        fun getFavorites(): MutableList<Product> {
                return this.favorites
        }

        fun getShoppingCart(): MutableList<Product> {
                return this.shoppingCart
        }

        fun displayFavorites(store: Store) {
                println("---------- MODA Store | FAVORITES----------")
                println("\tID \tProduct name \tPrice")
                this.favorites.forEach() {
                        println("\t${it.getIdProduct()} \t${it.getName()} \t${it.getPrice()}")
                }
                print(
                        "\nDo you want to ...?" +
                                "\n  1) Add product to cart" +
                                "\n  2) Remove a product" +
                                "\n  3) Return to menu please" +
                                "\n\n-> Choose an option: ")
                when (readLine().toString()) {
                        "1" -> addProductToCart()
                        "2" -> removeProductFromFavorites()
                }
        }

        private fun addProductToCart() {
                val product = findProduct(this.favorites, "favorites")
                if (product != null) {
                        addToCart(product)
                }
        }

        private fun removeProductFromFavorites() {
                val product = findProduct(this.favorites, "favorites")
                if (product != null) {
                        removeFromFavorites(product)
                }
        }

        private fun findProduct(list: MutableList<Product>, text: String): Product? {
                print("   -> Please enter the product ID: ")
                var id = readLine().toString()
                var selectedProduct = list.filter { id == it.getIdProduct().toString() }
                try {
                        return selectedProduct[0]
                } catch (e: Exception) {
                        println("Sorry, couldn't find a product with the ${id} id in your ${text} :(")
                        return null
                }
        }

        fun displayShoppingCart() {
                println("---------- MODA Store | SHOPPING CART----------")
                println("\tID \tProduct name \tPrice")
                this.shoppingCart.forEach() {
                        println("\t${it.getIdProduct()} \t${it.getName()} \t${it.getPrice()}")
                }
                print(
                        "\nDo you want to ...?" +
                                "\n  1) Proceed to payment" +
                                "\n  2) Remove a product" +
                                "\n  3) Return to menu please" +
                                "\n\n-> Choose an option: ")
        }

        fun displayOrders() {
                println("---------- MODA Store | ORDERS ----------")
                /* this.favorites.forEach() {
                        println(it.getName())
                }*/
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

        fun removeFromFavorites(product: Product) {
                println("The product ${product.getName()} has been removed to your cart")
                this.favorites.remove(product)
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

