package project;

import kotlin.collections.List as List1

class RegisteredUser(
    override val idUser: String,
    private val name: String,
    private val email: String,
    private var password: String): User(idUser){

    fun getName(): String {
        return this.name
    }

    fun getEmail(): String {
        return this.email
    }

    fun getPassword(): String {
        return this.password
    }

    fun logIn(store: Store) : Boolean {
        print("\n---------- MODA Store | LOG IN ----------\nUsername: ")
        var name = readLine().toString()
        print("Password: ")
        var password : String = readLine().toString()
        while (store.isInListOfUsersUsername(name) || store.isInListOfUsersPassword(password)){
            println("--- There is a problem in the LogIn")
            while(store.isInListOfUsersUsername(name)){
                println("--- This username doesn't exist, enter a valid username: ")
                name = readLine().toString()
                if(store.isInListOfUsersUsername(name) == false){
                    print("Password: ")
                    password = readLine().toString()
                }
            }
            while(store.isInListOfUsersPassword(password)){
                println("--- This password doesn't match, enter a valid password: ")
                password = readLine().toString()
            }
        }
        println("Welcome again $name to MODA Store")
        return false
    }

    fun logOut() : Boolean {
        print("\n---------- MODA Store | LOG OUT ----------")
        return true
    }


/*

fun perfil(){
        println("Bienvenido a tu perfil")
        println("Nombre: ${getName()}")
        println("Email: ${getEmail()}")
    }

fun addToFavorites(){

}

fun removeFromFavorites(){


}

fun changeSetting(){

}

fun setPassword(){

}

fun setAddress(){

}

fun setPaymentMethod(){

}
 */
}
