/**
 * Data class Order
 *
 * Contains the properties of an Order
 */
package project

import java.time.LocalDateTime

data class Order(
    val id: String,
    val products: List<Product>,
    val total: Float,
    val address: String,
    val pay: MutableMap<String,Map<String, String>>,
    val date: LocalDateTime)