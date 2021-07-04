package project

class RegisteredUser(idUsers: Int, name: String, email: String, password : String, address: String,
                     shoppingCart: MutableList<Product>) : User(idUsers, name, email, password, address, shoppingCart){

    /*
    //SETTERS
    @JvmName("setName1")
    private fun setName(name: String) {
        this.name = name
    }

    @JvmName("setEmail1")
    private fun setEmail(email: String) {
        this.email = email
    }

    @JvmName("setPassword1")
    private fun setPassword(password: String) {
        this.password = password
    }
     */

    //GETTERS
    @JvmName("getId1")
    fun getId(): Int{
        return idUsers
    }

    @JvmName("getName1")
    fun getName(): String{
        return name
    }

    @JvmName("getEmail1")
    fun getEmail(): String{
        return email
    }

/*
    @JvmName("getPassword")
    fun getPassword(): String{
        return password
    }

 */


    /*
    fun accountValidation(){
        println("Cuenta con registro? y/n")
        var status = readLine().toString()
        when (status) {
            "y", "Y" -> {
                println("Ingresa tu correo")
                var email1 : String = readLine().toString()
                println("Ingresa tu contraseña")
                var password1 : String = readLine().toString()
                var answer: Boolean = logIn(email1,password1)
                if (answer == true){
                    println("Usuario Registrado")
                } else {
                    println("Usuario no Registrado")
                }
            }
            "n", "N" -> {
                println("Desea registrarse?")
                var answer2 = readLine().toString()
                if(answer2 == "y" && answer2 == "Y") {
                    println("Agregar Login")
                    super.signIn()
                } else if (answer2 == "n" && answer2 == "N"){
                    println("Hasta pronto")
                }
            }
            else -> {
                println("Ingrese un valor valido")
                accountValidation()
            }
        }

    }

    private fun logIn(email1: String, password1: String): Boolean{
        for((i,j) in users){
            if (i == email1 && j == password1){
                return true
            }
        }
        return false
    }


     */

/*
fun SignIn(){

}

fun logIn(){

}

fun logOut(): Boolean{
    print("Are you sure you want to logout?")
    val statusLog : Boolean = readLine().toString()
    if(statusLog == true){
        println("Successful logout")
        status = false
    } else {
        println("Nothing changed")
    }
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

