import project.BaseDatos
import project.Store
import project.User
import project.RegisteredUser

val myStore: Store = BaseDatos.iniciar()
val myUser = User("1000")
var myRegisteredUser = RegisteredUser("","","","","","")
var generalUser = true


fun main() {
    displayMenu()
}

fun displayMenu() {
    var flag = true
    var opcion: String = ""

    while (flag && generalUser) {
        clear()
        print ("---------- WELCOME TO ${myStore.name} ----------" +
                "\n1) Search product" +
                "\n2) Sign in" +
                "\n3) Log in" +
                "\n4) Exit" +
                "\n\n-> Choose an option: ")
        opcion = readLine().toString()
        flag = userMenu(opcion)
    }

    while (flag && !generalUser) {
        clear()
        print ("---------- WELCOME TO ${myStore.name} | ${myRegisteredUser.getName()} | ----------" +
                "\n1) Search product" +
                "\n2) Profile" +
                "\n3) Log out" +
                "\n4) Exit" +
                "\n\n-> Choose an option: ")
        opcion = readLine().toString()
        flag = registeredUserMenu(opcion)
    }
}

fun userMenu(option: String): Boolean {
    when (option) {
        "1" -> myUser.searchProduct(myStore)
        "2" -> {
            myRegisteredUser = myUser.signIn(myStore)!!
            generalUser = false
        }
        "3" -> {
            myRegisteredUser = myRegisteredUser.logIn(myStore)!!
            generalUser = false
        }
        "4" -> {
            println("Thanks to be with us")
            return false
        }
        else -> {
            print("Sorry, please select a valid option(1-4)")
            userMenu(readLine().toString())
        }
    }
    return true
}

fun registeredUserMenu(option: String): Boolean {
    when (option) {
        "1" -> myRegisteredUser.searchProduct(myStore)
        "2" -> myRegisteredUser.profile(myRegisteredUser)
        "3" -> {
            generalUser = myRegisteredUser.logOut()
            displayMenu()
        }
        "4" -> {
            println("Thanks to be with us")
            return false
        }
        else -> {
            print("Sorry, please select a valid option(1-4)")
            registeredUserMenu(readLine().toString())
        }
    }
    return true
}

fun clear() {
    for (i in 0..20) {
        println()
    }
}
