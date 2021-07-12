package project


import kotlin.collections.List as List1

class RegisteredUser(
    override val idUser: String,
    private var name: String,
    private var email: String,
    private var password: String,
    private var address: String,
    private var payment: String): User(idUser){

    private var shoppingCart = mutableListOf<Product>()
    private var orders = mutableListOf<String>()
    private var devolutions = mutableListOf<String>()
    private var favorites = mutableListOf<Product>()
    //private var address = ""

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
    fun setName(name:String){
         this.name = name
    }

    fun setEmail(email:String) {
         this.email = email
    }
    fun setPassword(password:String) {
        this.password= password
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

    /*
    fun addToCart(product: Product) {
            println("The product ${product.getName()} has been added to your cart")
            this.shoppingCart.add(product)
    }
    */

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


/*
fun addToFavorites(){
}
fun removeFromFavorites(){
}
 */