package project;

import kotlin.collections.List

class RegisteredUser(
        override val idUser: String,
        private val name: String,
        private val email: String,
        private var password: String): User(idUser){

        private var address = ""
        private var paymentMethod: MutableMap<String,Map<String, String>> =
                mutableMapOf("Credit card" to mapOf(),
                        "Debit card" to mapOf())
        private var shoppingCart = mutableListOf<Product>()
        private var favorites = mutableListOf<Product>()
        private var orders = mutableListOf<String>()

        fun getName(): String {
                return this.name
        }

        fun getEmail(): String {
                return this.email
        }

        fun getPassword(): String {
                return this.password
        }

        fun getAddress(): String {
                return this.address
        }

        fun getShoppingCart(): MutableList<Product> {
                return this.shoppingCart
        }

        fun getFavorites(): MutableList<Product> {
                return this.favorites
        }

        fun setAddress(address: String) {
                this.address = address
        }

        fun setPaymentMethod(type: String, data: Map<String,String>) {
                this.paymentMethod[type] = data
        }


        fun displayFavorites() {
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
                        print("Are you sure you want to remove the product ${product.name} from your list of favorites? y/n ")
                        if (readLine().toString() == "y") removeFromFavorites(product)
                        else println("The product ${product.name} is still on your list")
                }
        }

        fun displayShoppingCart(store: Store) {
                println("---------- MODA Store | SHOPPING CART----------")
                println("\tID \tProduct name \tPrice")
                this.shoppingCart.forEach() {
                        println("\t${it.getIdProduct()} \t${it.getName()} \t${it.getPrice()}")
                }
                print(
                        "\nDo you want to ...?" +
                                "\n  1) Proceed to payment" +
                                "\n  2) Remove a product" +
                                "\n  3) Add a product " +
                                "\n  4) Return to menu please" +
                                "\n\n-> Choose an option: ")
                when (readLine().toString()) {
                        "1" -> makePurchase()
                        "2" -> removeProductFromCart()
                        "3" -> searchProduct(store, this)
                }
        }

        private fun makePurchase() {
                println("---------- MODA Store | PAYMENT ----------")
                var total = 0F
                shoppingCart.forEach() {
                        println(" - ${it.getName()}\t $ ${it.getPrice()}")
                        total += it.getPrice()
                }
                var iva = total * 0.16F
                println("Subtotal: $ ${total}\nIVA: ${iva}\nTotal a pagar: ${total + iva}")

                var res: String
                if (this.address.isNotEmpty()) {
                        print("\n! You have the following saved address ${this.address} do you want to use it? y/n: ")
                        res = readLine().toString()
                        while (res != "y" && res != "n") {
                                print("\n--> please enter \"y\" for yes or \"n\" for no: ")
                                res = readLine().toString()
                        }
                        if (res == "n") this.address = ""
                }
                while (this.address.isEmpty()) {
                        println("\n! Please enter your address")
                        this.address = fillAddressData()
                }


                //checar si tiene un payment method guardado y preguntar si deasea usarlo
                print("\nSelect your payment method" +
                        "\n  1) Credit card" +
                        "\n  2) Debit card" +
                        "\n-> Choose an option: ")
                var type = readLine().toString()
                var flag = true

                while (flag) {
                        if (type == "1"){
                                type = "Credit card"
                                flag = false
                        } else if (type == "2"){
                                type = "Debit card"
                                flag = false
                        } else{
                                print("\n--> please enter \"1\" for Credit Card or \"2\" for Debit Card: ")
                                type = readLine().toString()
                        }
                }

                var save = false

                if (paymentMethod.getValue(type).values.isEmpty()) {
                        println("\n! Please enter your $type data")
                        save = fillCardData(type)
                } else {
                        val num = this.paymentMethod[type]?.getValue("Number")
                        print("\n! You have a $type saved, with the number $num do you want to use it? y/n: ")
                        if (readLine().toString() == "n"){
                                println("Then please enter your $type data")
                                save = fillCardData(type)
                        } else {
                                println("Okey, let's proceed! :)")
                        }
                }

                //generar compra

                if (!save) {
                        this.paymentMethod[type] = mapOf()
                }

                this.shoppingCart = mutableListOf()
        }

        private fun fillAddressData(): String {
                var userAddress = ""
                print("Street: ")
                userAddress += readLine().toString() + " "
                print("\nNº: ")
                userAddress += readLine().toString() + " "
                print("\nCountry: ")
                userAddress += readLine().toString() + ", "
                print("\nState: ")
                userAddress += readLine().toString() + ", "
                print("\nPostal code: ")
                userAddress += readLine().toString()

                return userAddress
        }

        private fun fillCardData(type: String): Boolean {
                print("Number (16): ")
                var number = readLine().toString()
                while (number.length < 15) {
                        print("Enter a valid number, must have 16 digits: ")
                        number = readLine().toString()
                }

                print("\nDate MM/YY: ")
                var date = readLine().toString()
                while (date.length < 4) {
                        print("Enter a valid date: ")
                        date = readLine().toString()
                }

                print("\nSecurity number (3): ")
                var securityNum = readLine().toString()
                while (securityNum.length < 2) {
                        print("Enter a valid security number, must have 3 digits: ")
                        securityNum = readLine().toString()
                }

                val data = mapOf("Number" to number, "Date" to date, "Security number" to securityNum )

                this.paymentMethod[type] = data

                print("Do you want to save your payment method for future purchases? y/n: ")
                if (readLine().toString() == "y") {
                        println ("Payment method saved")
                        return true
                }
                println ("The payment method wasn't saved for future purchases")
                return false
        }

        private fun removeProductFromCart() {
                val product = findProduct(this.shoppingCart, "cart")
                if (product != null) {
                        print("Are you sure you want to remove the product ${product.name} from your cart? y/n ")
                        if (readLine().toString() == "y") removeFromCart(product)
                        else println("The product ${product.name} is still on your cart")
                }
        }

        private fun findProduct(list: MutableList<Product>, text: String): Product? {
                print("   -> Please enter the product ID: ")
                var id = readLine().toString()
                var selectedProduct = list.filter { id == it.getIdProduct().toString() }
                try {
                        return selectedProduct[0]
                } catch (e: Exception) {
                        println("Sorry, couldn't find a product with the id ${id} in your ${text} :(")
                        return null
                }
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

                return regUser
        }

        fun logOut() : Boolean {
                print("\n---------- MODA Store | LOG OUT ----------")
                return true
        }

        fun profile(user: RegisteredUser){
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

        private fun removeFromCart(product: Product) {
                println("The product ${product.getName()} has been removed to your cart")
                this.shoppingCart.remove(product)
        }

        fun addToFavorite(product: Product) {
                println("The product ${product.getName()} has been added to your favorite list")
                this.favorites.add(product)
        }

        private fun removeFromFavorites(product: Product) {
                println("The product ${product.getName()} has been removed to your cart")
                this.favorites.remove(product)
        }
}

/*
Registered User
- profile: configuracion
- compras: id, carrito, total, fecha
- agregar a carrito
 */

