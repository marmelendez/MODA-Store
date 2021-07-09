package project;

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

        fun logIn() {
                print("\n---------- MODA Store | LOG IN ----------\nEmail or username:? ")
                readLine().toString()
                print("Password: ")
                readLine().toString()

        }

        fun logOut() {
                print("\n---------- MODA Store | LOG OUT ----------\nHi there, which product are you looking for? ")

        }
}


