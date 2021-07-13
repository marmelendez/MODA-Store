package project

import kotlinx.coroutines.runBlocking

val myStore: Store = BaseDatos.start()
val myUser = User("1000")
var myRegisteredUser = RegisteredUser("","","","")
var generalUser = true


fun main() =  runBlocking {
    displayMenu()
}

suspend fun displayMenu() {
    var flag = true
    var option: String

    // Mientras el usuario no este registrado, muestra el siguiente menu
    while (flag && generalUser) {
        clear()
        print ("----------WELCOME TO ${myStore.name}----------" +
                "\n1) Search product" +
                "\n2) Sign in" +
                "\n3) Log in" +
                "\n4) Exit" +
                "\n\n-> Choose an option: ")
        option = readLine().toString()
        flag = userMenu(option)
    }

    // Mientras el usuario este registrado, muestra el siguiente menu
    while (flag && !generalUser) {
        clear()
        print ("----------WELCOME TO ${myStore.name}----------" +
                "\n1) Search product" +
                "\n2) Profile" +
                "\n3) Check favorites" +
                "\n4) Check shopping cart" +
                "\n5) Check orders" +
                "\n6) Log out" +
                "\n\n-> Choose an option: ")
        option = readLine().toString()
        flag = registeredUserMenu(option)
    }
}

// Evalucion de opciones del menu de usuario general
suspend fun userMenu(option: String): Boolean {
    when (option) {
        "1" -> myUser.searchProduct(myStore)
        "2" -> {
            myRegisteredUser = myUser.signIn(myStore)
            generalUser = false
        }
        "3" -> {
            myRegisteredUser = myRegisteredUser.logIn(myStore)!!
            generalUser = false
        }
        "4" -> {
            println("Thanks! See you :)")
            return false
        }
        else -> {
            print("Sorry, please select a valid option(1-4): ")
            userMenu(readLine().toString())
        }
    }
    return true
}

// Evalucion de opciones del menu de usuario registrado
suspend fun registeredUserMenu(option: String): Boolean {
    when (option) {
        "1" -> myRegisteredUser.searchProduct(myStore, myRegisteredUser)
        "2" -> myRegisteredUser.profile()
        "3" -> myRegisteredUser.displayFavorites()
        "4" -> myRegisteredUser.displayShoppingCart(myStore)
        "5" -> myRegisteredUser.displayOrders()
        "6" -> {
            generalUser = myRegisteredUser.logOut()
            displayMenu()
        }
        "7" -> {
            println("Thanks! See you :)")
            return false
        }
        else -> {
            print("Sorry, please select a valid option(1-4): ")
            registeredUserMenu(readLine().toString())
        }
    }
    return true
}

fun clear() {
    for (i in 0..10) {
        println()
    }
}
