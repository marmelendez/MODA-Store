import project.BaseDatos
import project.Store
import project.GuestUser

val myStore: Store = BaseDatos.iniciar()
val myUser = GuestUser("1000")


fun main() {
    displayMenu()
}

fun displayMenu() {
    var flag = true
    var opcion: String = ""

    while (flag) {
        clear()
        print ("----------WELCOME TO ${myStore.name}----------" +
                "\n1) Search product" +
                "\n2) Sign in" +
                "\n3) Log in" +
                "\n4) Profile" +
                "\n5) Log out" +
                "\n\n-> Choose an option: ")
        opcion = readLine().toString()

        flag = evalOption(opcion)
    }
}

fun evalOption(option: String): Boolean {
    when (option) {
        "1" -> myUser.searchProduct(myStore)
        "2" -> myUser.signIn(myStore)
        "3" -> println("iniciar sesion")
        "4" -> println("perfil")
        "5" -> {
            println("salir")
            return false
        }
        else -> {
            print("Sorry, please select a valid option(1-5)")
            evalOption(readLine().toString())
        }
    }
    return true
}

fun clear() {
    for (i in 0..20) {
        println()
    }
}