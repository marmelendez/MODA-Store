/**
 * Data class Product
 *
 * Contains the properties of a Product
 */
package project

data class Product(
    val idProduct: Int,
    var name: String,
    var category: Category,
    var color: String,
    var price: Float,
    var quantity: Map<String, Int>)

