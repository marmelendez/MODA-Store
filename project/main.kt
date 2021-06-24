package project

fun main() {
    //Instanciar clase Category
    var myCategory1 = Category(10000,"Dama")
    var myCategory2 = Category(10001,"Caballero")

    //Instanciar clase Product
    var myProduct1 = Product(10000,
        "Blusa estampada",
        myCategory1,
        "Azul",
        "S",
        130F,
        100)
    var myProduct2 = Product(10001,
        "Pantalon mezclilla",
        myCategory2,
        "Negro",
        "XL",
        350F,
        50)
    var myProduct3 = Product(10002,
        "Camisa con cuello",
        myCategory2,
        "Blanca",
        "M",
        200F,
        70)

    //Instanciar clase Store y añadir productos al catalogo
    var myStore = Store()
    myStore.addProduct(myProduct1)
    myStore.addProduct(myProduct2)
    myStore.addProduct(myProduct3)

    //Mostrar productos
    myStore.displayProducts()

    //Instanciar clase User y uso de metodos: signIn y searchProduct
    var myUser = User("12345")

    //Solicitar datos al usuario
    myUser.signIn()

    //Buscar un producto
    myUser.searchProduct(myStore)

    //Agregar al carrito
    myUser.addToCart(myProduct1)
    myUser.addToCart(myProduct2)
    myUser.displayShoppingCart()

    //Eliminar un producto del carrito
    myUser.removeFromCart(myProduct1)
    myUser.displayShoppingCart()
}
