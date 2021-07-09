package project;

class RegisteredUser(
        override val idUser: String,
        private val name: String,
        private val email: String,
        private var password: String): User(idUser){

}
