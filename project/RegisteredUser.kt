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


