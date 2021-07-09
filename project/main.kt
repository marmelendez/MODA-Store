import project.BaseDatos
import project.Store
import project.User

val myStore: Store = BaseDatos.iniciar()
val myUser = User("1000")


fun main() {
    displayMenu()
}

fun displayMenu() {
    var flag = true
    var opcion: String = ""

    while (flag) {
        print ("----------WELCOME TO ${myStore.name}----------" +
                "\n1) Search product" +
                "\n2) Sign in" +
                "\n3) Log in" +
                "\n4) Profile" +
                "\n5) Log out" +
                "\n-> Choose an option: ")
        opcion = readLine().toString()

        flag = evalOption(opcion)
    }
}

fun evalOption(option: String): Boolean {
    when (option) {
        "1" -> myUser.searchProduct(myStore)
        "2" -> println("registrarse") //Solicitar datos, validarlos y crear un usuario registrado
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
