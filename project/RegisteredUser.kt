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

    fun logIn(store: Store) {
        print("\n---------- MODA Store | LOG IN ----------\nUsername: ")
        var name = readLine().toString()
        print("Password: ")
        var passwordValidation : String = readLine().toString()
        while (store.isInListOfUsersUsername(name) || store.isInListOfUsersPassword(passwordValidation)){
            println("--- There is a problem in the LogIn")
            while(store.isInListOfUsersUsername(name)){
                println("--- This username doesn't exist, enter a valid username: ")
                name = readLine().toString()
                if(store.isInListOfUsersUsername(name) == false){
                    print("Password: ")
                    passwordValidation = readLine().toString()
                }
            }
            while(store.isInListOfUsersPassword(passwordValidation)){
                println("--- This password doesn't match, enter a valid password: ")
                passwordValidation = readLine().toString()
            }
        }
        println("Welcome again to MODA Store")
    }

    fun logOut() {
        print("\n---------- MODA Store | LOG OUT ----------\nHi there, which product are you looking for? ")
    }

/*
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
