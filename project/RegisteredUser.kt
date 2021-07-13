package project

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class RegisteredUser(
        override val idUser: String,
        private val name: String,
        private val email: String,
        private var password: String): User(idUser){

        private var address = ""
        private var shoppingCart = mutableListOf<Product>()
        private var favorites = mutableListOf<Product>()
        private var orders = mutableListOf<Order>()
        private var paymentMethod: MutableMap<String,Map<String, String>> =
                mutableMapOf("Credit card" to mapOf(), "Debit card" to mapOf())

        fun getName(): String {
                return this.name
        }

        fun getEmail(): String {
                return this.email
        }

        private fun getPassword(): String {
                return this.password
        }
        
        fun setAddress(address: String) {
                this.address = address
        }

        fun setPaymentMethod(type: String, data: Map<String,String>) {
                this.paymentMethod[type] = data
        }

        private fun findProduct(list: MutableList<Product>, text: String): Product? {
                print("   -> Please enter the product ID: ")
                val id = readLine().toString()
                val selectedProduct = list.filter { id == it.idProduct.toString() }
                return try {
                        selectedProduct[0]
                } catch (e: Exception) {
                        println("Sorry, couldn't find a product with the id $id in your $text :(")
                        null
                }
        }

        fun displayFavorites() {
                println("---------- MODA Store | FAVORITES----------")
                println("\tID \tProduct name \tPrice")
                if (this.favorites.isEmpty()) {
                        println("Your list of favorites is empty :( \n\nPress ENTER and return to menu to find some cool products")
                } else {
                        this.favorites.forEach { println("\t${it.idProduct} \t${it.name} \t${it.price}")}
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
                readLine()
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
                if (this.shoppingCart.isEmpty()) {
                        println("Your cart is empty :( \n\nPress ENTER and return to the menu to find some cool products")
                } else {
                        this.shoppingCart.forEach { println("\t${it.idProduct} \t${it.name} \t${it.price}") }
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
                readLine()
        }

        private fun makePurchase() {
                println("---------- MODA Store | PAYMENT ----------")
                if (shoppingCart.isEmpty()) {
                        println("Sorry, your cart is empty")
                } else {
                        val total = getTotal()
                        askAddress()
                        val type = askPaymentMethod()
                        var ask =  true
                        if (paymentMethod.getValue(type).values.isNotEmpty()) ask = false
                        checkPaymentMethod(type)
                        println()
                        addOrder(Order(this.orders.size.toString(), this.shoppingCart,total,this.address, this.paymentMethod, LocalDateTime.now()))

                        if (ask) {
                                print("Do you want to save your payment method for future purchases? y/n: ")
                                if (readLine().toString() == "y") {
                                        println ("Payment method saved")
                                } else {
                                        this.paymentMethod[type] = mapOf()
                                        println ("The payment method wasn't saved for future purchases")
                                }
                                this.shoppingCart = mutableListOf()
                        }
                }
        }

        private fun getTotal(): Float {
                var subtotal = 0F
                shoppingCart.forEach {
                        println(" - ${it.name}\t $ ${it.price}")
                        subtotal += it.price
                }
                val iva = subtotal * 0.16F
                val total = subtotal + iva
                println("Subtotal: $ ${subtotal}\nIVA: ${iva}\nTotal a pagar: $total")
                return total
        }

        private fun askAddress() {
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

        private fun askPaymentMethod(): String {
                print("\nSelect your payment method" +
                        "\n  1) Credit card" +
                        "\n  2) Debit card" +
                        "\n-> Choose an option: ")
                var type = readLine().toString()
                var flag = true

                while (flag) {
                        when (type) {
                                "1" -> {
                                        type = "Credit card"
                                        flag = false
                                }
                                "2" -> {
                                        type = "Debit card"
                                        flag = false
                                }
                                else -> {
                                        print("\n--> please enter \"1\" for Credit Card or \"2\" for Debit Card: ")
                                        type = readLine().toString()
                                }
                        }
                }
                return type
        }

        private fun checkPaymentMethod(type: String) {
                if (this.paymentMethod.getValue(type).values.isEmpty()) {
                        println("\n! Please enter your $type data")
                        fillCardData(type)
                } else {
                        val num = this.paymentMethod[type]?.getValue("Number")
                        print("\n! You have a $type saved, with the number $num do you want to use it? y/n: ")
                        var res = readLine().toString()
                        while (res != "y" && res != "n") {
                                print("\n--> please enter \"y\" for yes or \"n\" for no: ")
                                res = readLine().toString()
                        }
                        if (res == "n"){
                                println("Then please enter your $type data")
                                fillCardData(type)
                        } else {
                                println("Okey, let's proceed! :)")
                        }
                }
        }

        private fun fillCardData(type: String) {
                print("Number (16 digits): ")
                var number = readLine().toString()
                number = getValidData(number, 15, "Enter a valid number, must have 16 digits: ")

                print("Date MM/YY: ")
                var date = readLine().toString()
                date = getValidData(date, 5,"Enter a valid date: ")

                print("Security number (3 digits): ")
                var securityNum = readLine().toString()
                securityNum = getValidData(securityNum, 3, "Enter a valid security number, must have 3 digits: ")

                val data = mapOf("Number" to number, "Date" to date, "Security number" to securityNum )
                this.paymentMethod[type] = data
        }

        private fun getValidData(response: String, cond: Int, message: String): String{
                var data = response
                while (data.length < cond) {
                        print("--- $message")
                        data = readLine().toString()
                }
                return data
        }

        private fun removeProductFromCart() {
                val product = findProduct(this.shoppingCart, "cart")
                if (product != null) {
                        print("Are you sure you want to remove the product ${product.name} from your cart? y/n ")
                        if (readLine().toString() == "y") removeFromCart(product)
                        else println("The product ${product.name} is still on your cart")
                }
        }


        fun displayOrders() {
                println("---------- MODA Store | ORDERS ----------")
                this.orders.forEach { it ->
                        println("-----------------------------------------" +
                                "\n ID: ${it.id}" +
                                "\n Products:")
                        it.products.forEach { println("  - \t${it.name}   \t$${it.price}") }
                        println(" Total: $ ${it.total}" +
                                "\n Address: ${it.address}" +
                                "\n Date: ${it.date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))}" +
                                "\n-----------------------------------------")
                }
                readLine()
        }

        fun logIn(store: Store) : RegisteredUser? { //Boolean
                print("\n---------- MODA Store | LOG IN ----------\nUsername: ")
                var name = readLine().toString()

                while (store.getUser(name) == null) {
                        print("Sorry the username $name is not registered. Try with another one: ")
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
                        println("\n Welcome again $name to MODA Store! :)")
                } else {
                        println("\n ! Sorry couldn't find an account with the username $name")
                }

                readLine()
                return regUser
        }

        fun logOut() : Boolean {
                print("\n---------- MODA Store | LOG OUT ----------")
                return true
        }

        fun profile(user: RegisteredUser){
            println("---------- MODA Store | PROFILE ----------")
            println("Welcome again ${user.name} to MODA Store")

            println("\nProfile information" +
                    "\n\tID: ${user.idUser}" +
                    "\n\tNombre: ${user.name}" +
                    "\n\tEmail: ${user.email}"+
                    "\n\tAddress: ${user.address}"+
                    "\n\tPayment Method: ${user.payment}")
            if(user.address == ""|| user.payment=="") println("Some lands are blanked"+"\nConsider to fill it")

            var flag = true
            while(flag){
                println("\n\nWhat would you like to do?" +
                        "\n1) Change settings" +
                        "\n2) Add information" +
                        "\n3) Return to menu" +
                        "\n\n-> Choose an option: ")
                var option = readLine().toString()
                when (option) {
                    "1" -> {
                        changeSettings(user)
                        profile(user)
                    }
                    "2" -> {
                        addInformation(user)
                        profile(user)
                    }
                    "3" -> flag = false
                    else -> {
                        println("Sorry, please select a valid option(1-2)\n")
                    }
                }
            }
        }
        
        fun changeSettings(user: RegisteredUser){
            var flag = true
            while(flag){
                println("What would you like to change?" +
                        "\n1) Name" +
                        "\n2) Email" +
                        "\n3) Password" +
                        "\n4) Address" +
                        "\n5) Payment Method" +
                        "\n6) Return to profile" +
                        "\n\n-> Choose an option: ")
                var option = readLine().toString()
                when (option) {
                    "1" -> {
                        println("Enter a new Name")
                        var name= readLine()?.toString()
                        while (name == null ){
                            println("Please enter a new name")
                            name = readLine()?.toString()
                        }
                        setName(name)
                        println("Your name has been changed to $name")
                    }
                    "2" -> { println("Enter a new Email")
                        var email= readLine()?.toString()
                        while (email == null ){
                            println("Please enter a new Email")
                            email = readLine()?.toString()
                        }
                        setEmail(email)
                        println("Your name has been changed to $email")
                    }
                    "3" -> { println("Enter a new Password")
                        var password= readLine()?.toString()
                        while (password == null ){
                            println("Please enter a new Password")
                            password = readLine()?.toString()
                        }
                        setPassword(password)
                        println("Your name has been changed to $password")
                    }
                    "4" -> setAddress(user)
                    "5" -> setPaymentMethod(user)
                    "6" -> flag = false
                    else -> {
                        println("Sorry, please select a valid option(1-6)\n")
                    }
                }
            }
        }

        fun addInformation(user: RegisteredUser){
            var flag = true
            while(flag){
                println("What type of information would you like to add?" +
                        "\n1) Add address" +
                        "\n2) Add payment method" +
                        "\n3) Return to profile" +
                        "\n\n-> Choose an option: ")
                var option = readLine().toString()
                when (option) {
                    "1" -> setAddress(user)
                    "2" -> setPaymentMethod(user)
                    "3" -> flag = false
                    else -> {
                        println("Sorry, please select a valid option(1-3)\n")
                    }
                }
            }
        }

        fun setPaymentMethod(user: RegisteredUser){
            println("\nLast payment method: ${user.payment}")
            println("Set your payment method: ")
            user.payment = readLine().toString()
            println("\nPayment method updated: ${user.payment}\n\n")
        }

        fun setAddress(user: RegisteredUser){
            println("\nLast address: ${user.address}")
            println("Set your address: ")
            user.address = readLine().toString()
            println("\nAddress updated: ${user.address}\n\n")
        }

        fun addToCart(product: Product) {
                println("The product ${product.name} has been added to your cart")
                this.shoppingCart.add(product)
        }

        private fun removeFromCart(product: Product) {
                println("The product ${product.name} has been removed to your cart")
                this.shoppingCart.remove(product)
        }

        fun addToFavorite(product: Product) {
                println("The product ${product.name} has been added to your favorite list")
                this.favorites.add(product)
        }

        private fun removeFromFavorites(product: Product) {
                println("The product ${product.name} has been removed to your cart")
                this.favorites.remove(product)
        }

        private fun addOrder(order: Order) {
                println("The order ${order.id} with a total of $ ${order.total} has been completed!")
                this.orders.add(order)
        }
}