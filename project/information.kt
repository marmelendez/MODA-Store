package project

var listProducts = mutableListOf<Product>()
var listUsers = mutableListOf<RegisteredUser>()
var listCategory = mutableListOf<Category>()
var shoppingCart = mutableListOf<Product>()

var idProduct = 1
var idUsers = 1
var idCategory = 1

fun setCategory(): MutableList<Category>{
    listCategory.add(Category(idCategory++,"Dama"))
    listCategory.add(Category(idCategory++,"Caballero"))
    listCategory.add(Category(idCategory++,"Niños"))
    listCategory.add(Category(idCategory++,"Bebes"))
    return listCategory
}

fun setProducts(listCategory: MutableList<Category>): MutableList<Product>{
    listProducts.add(Product(idProduct++,"Blusa estampada",listCategory[0],"Rosa","S",130F,100))
    listProducts.add(Product(idProduct++,"Short",listCategory[0],"Azul","S",300F,30))
    listProducts.add(Product(idProduct++,"Pantalon mezclilla",listCategory[1],"Negro","XL",350F,50))
    listProducts.add(Product(idProduct++,"Camisa con cuello",listCategory[1],"Blanca","M",200F,70))
    listProducts.add(Product(idProduct++,"Pijama",listCategory[2],"Naranja","S",250F,50))
    listProducts.add(Product(idProduct++,"Camisa",listCategory[2],"Blanca","M",80F,70))
    listProducts.add(Product(idProduct++,"Camisa",listCategory[3],"Azul","S",350F,90))
    listProducts.add(Product(idProduct++,"Pants",listCategory[3],"Cafe","S",120F,20))
    return listProducts
}

fun setShoppingCart(listProducts : MutableList<Product>): MutableList<Product>{
    shoppingCart.add(listProducts[0])
    shoppingCart.add(listProducts[1])
    return shoppingCart
}

fun setStore(listCategory: MutableList<Category>, listProducts : MutableList<Product>): Store{
    val myStore = Store()
    for(i in 0 .. listCategory.size - 1){
        myStore.addCategory(listCategory[i])
    }
    for(i in 0 .. listProducts.size - 1){
        myStore.addProduct(listProducts[i])
    }
    return myStore
}

fun setUsers(shoppingCart: MutableList<Product>) : MutableList<RegisteredUser>{
    listUsers.add(RegisteredUser(idUsers++,"Tomas","tomas@gmail.com",
        "tomas123","Norte 56 No.4862, CDMX",shoppingCart))
    listUsers.add(RegisteredUser(idUsers++,"Jose","jose@gmail.com",
        "jose123","Sur 78 No.1135, CDMX",shoppingCart))
    listUsers.add(RegisteredUser(idUsers++,"Lizbeth","lizbeth@gmail.com",
        "lizbeth123","Oeste 46 No.25, Durango",shoppingCart))
    listUsers.add(RegisteredUser(idUsers++,"Didier","didier@gmail.com",
        "didier123","Este 56 No.63,Cancun",shoppingCart))
    listUsers.add(RegisteredUser(idUsers++,"","","","",shoppingCart))
    return listUsers
}


/*
var listProducts = Array<Product?>(10){null}
var listUsers = Array<RegisteredUser?>(10){null}
var listCategory = Array<Category?>(10){null}
var idProduct = 0
var idUsers = 0
var idCategory = 0

fun setCategory(): Array<Category?>{
    listCategory[idCategory]= Category(idCategory++,"Dama")
    listCategory[idCategory]= Category(idCategory++,"Caballero")
    return listCategory
}

fun setProducts(listCategory: Array<Category>): Array<Product?>{
    listProducts[idProduct]= Product(idProduct++,"Blusa estampada",listCategory[0],
        "Azul","S",130F,100)
    listProducts[idProduct]= Product(idProduct++,"Pantalon mezclilla",listCategory[1],
        "Negro","XL",350F,50)
    listProducts[idProduct]= Product(idProduct++,"Camisa con cuello",listCategory[1],
        "Blanca","M",200F,70)
    return listProducts
}

fun setShoppingCart(listProducts : Array<Product>): MutableList<Product>{
    var shoppingCart = mutableListOf<Product>()
    shoppingCart.add(listProducts[1])

    return shoppingCart
}

fun setUsers(shoppingCart: MutableList<Product>){
    listUsers[idUsers]= RegisteredUser(idUsers++,"Tomas","tomas@gmail.com",
        "tomas123","Norte 56 No.4862, CDMX",shoppingCart)
    listUsers[idUsers]= RegisteredUser(idUsers++,"Jose","jose@gmail.com",
        "jose123","Sur 78 No.1135, CDMX",shoppingCart)
    listUsers[idUsers]= RegisteredUser(idUsers++,"Lizbeth","lizbeth@gmail.com",
        "lizbeth123","Oeste 46 No.25, Durango",shoppingCart)
    listUsers[idUsers]= RegisteredUser(idUsers++,"Didier","didier@gmail.com",
        "didier123","Este 56 No.63,Cancun",shoppingCart)
    listUsers[idUsers]= RegisteredUser(idUsers++,"","","","",shoppingCart)
}
 */


/*
    println("Welcome to MODA Store")
    println("1. Sign In")
    println("2. Search a product")
    println("3. Add a product")
    println("4. Display Shopping Car")

    println("Choose an option")
    var option = readLine().toString()
    if(option == "1"){
        myUser.signIn()
    }  else if (option == "2"){
        myUser.searchProduct(myStore)
    } else if (option == "3"){
        myUser.addToCart(myProduct1)
        myUser.addToCart(myProduct2)
        myUser.addToCart(myProduct3)
    } else if (option == "4"){
        myUser.displayShoppingCart()
    }

 */