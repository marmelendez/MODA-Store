package project

import kotlin.collections.List as List1

open class User (open val idUser: String) {

    fun signIn(store: Store): RegisteredUser {
        //validar que no esten ya registrados y que sean validos
        print("---------- MODA Store | SIGN IN ----------\n\n-> Please enter your username: ")
        var name = readLine().toString()
        var error1 =
            "--- Enter a valid username (start with a letter, can contain letters and numbers and at least 6 characters): "
        var error2 = "--- The given username is already registered: "
        while (!validate(name, error1, Form.validateUsername(name)) || !validate(
                name,
                error2,
                store.isInListOfUsersUsername(name)
            )
        ) {
            name = readLine().toString()
        }

        print("\n-> Now your email: ")
        var email = readLine().toString()
        error1 = "--- Enter a valid email (ends with @domain.com): "
        error2 = "--- The given email is already registered: "
        while (!validate(email, error1, Form.validateEmail(email)) || !validate(
                email,
                error2,
                store.isInListOfUsersEmail(email)
            )
        ) {
            email = readLine().toString()
        }

        print("\n-> And your password, we recommend you this one ${Form.passwordGenerator()}: ")
        var password = readLine().toString()
        error1 = "--- Enter a valid password (minimum length: 8,can contain letters, numbers or . / _): "
        while (!validate(password, error1, Form.validatePassword(password))) {
            password = readLine().toString()
        }

        //crear usuario registrado
        val newUser = RegisteredUser(idUser, name, email, password)
        store.addUser(newUser)

        //Agregar corutina
        println("\nWelcome ${newUser.getName()}! now you have an account")

        return newUser
    }

    fun validate(data: String, error: String, funValidate: Boolean): Boolean {
        if (!funValidate) {
            print(error)
            return false
        }
        return true
    }

    fun searchProduct(store: Store, user: RegisteredUser? = null) {
        var flag = true
        var option: String
        while (flag) {
            print("\n---------- MODA Store | SEARCH ----------\nHi there, which product are you looking for? ")

            var productName = readLine().toString()

            val result = store.catalogProduct.filter { it.getName().toLowerCase().contains(productName.toLowerCase()) }
            val text = if (result.isNotEmpty()) " We found ${result.size} results :)" else " Sorry no match found :("
            println("${text}\n\tID \tName")
            result.forEach { println("\t${it.getIdProduct()} \t${it.getName()}") }

            print(
                "\nDo you want to ...?" +
                        "\n  1) Search another product" +
                        "\n  2) Select a product " +
                        "\n  3) Return to menu please" +
                        "\n\n-> Choose an option: "
            )
            option = readLine().toString()
            if (option != "1") flag = false
            if (option == "2") {
                print("   -> Please enter the product ID: ")
                var id = readLine().toString()
                var selectedProduct = store.catalogProduct.filter { id == it.getIdProduct().toString() }
                try {
                    selectProduct(selectedProduct[0], user)
                } catch (e: Exception) {
                    println("Sorry, couldn't find a product with the ${id} id :(")
                }
            }
        }
    }

    fun selectProduct(product: Product, user: RegisteredUser?) {
        println("\n---------- MODA Store | ${product.name} ----------" +
                "\nID: ${product.idProduct}" +
                "\nPrice: ${product.price}" +
                "\nColor: ${product.color}" +
                "\nCategory: ${product.getCategory().getName()}" +
                "\nSize: ${product.getQuantity().map { it.key }}"
        )
        print(
            "\nDo you want to ...?" +
                    "\n  1) Add to cart" +
                    "\n  2) Add to favorites " +
                    "\n  3) Return to menu please" +
                    "\n\n-> Choose an option: "
        )
        var op = readLine().toString()
        if (op == "1" || op == "2") {
            if(user != null){
                when (op){
                    "1" -> user.addToCart(product)
                    "2" -> user.addToFavorite(product)
                }
            } else {
                println("You don't have access to this part, please sign in or log in")
            }
        }
    }
}

//Checar la parte mostrar un producto y su menu de opciones