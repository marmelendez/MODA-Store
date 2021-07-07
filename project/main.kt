import project.Store
import project.User

val myStore = Store()
val myUser = User("1000")


fun main() {
    //BaseDatos.iniciar()
    displayMenu()

}

fun displayMenu() {
    var flag = true
    var opcion: String = ""

    while (flag) {
        print ("----------WELCOME TO MODA STORE----------" +
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
        "2" -> println("registrarse")
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
