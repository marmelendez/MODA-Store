package project

fun main() {
    var categories = setCategory()
    var products = setProducts(categories)
    var shoppingcart = setShoppingCart(products)
    var store = setStore(categories, products)
    var users = setUsers(shoppingcart)

    users.forEach() {
        println(" ID: ${it.getId()}\t Name: ${it.getName()}\t Email: ${it.getEmail()}")
    }

    /*
    println("\n")
    println("Category size:${categories.size}")
    println("Products size:${products.size}\n")
    categories.forEach() {
        println(" ID: ${it.getId()}\t Name: ${it.getName()}")}
    println("\n")
    store.displayProducts()
     */

}