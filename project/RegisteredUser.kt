package project;

class RegisteredUser(
        override val idUser: Int,
        private val name: String,
        private val email: String,
        private var password: String): User(idUser){

}
