package project

class Product(
    val idProduct: Int,
    var name: String,
    var category: Category,
    var color: String,
    var size: String,
    var price: Float,
    var quantity: Int
) {
    var status = false
    init{
        if (this.quantity!! > 0){this.status = true}
    }

    @JvmName("getName1")
    fun getName(): String{
        return this.name.toString()
    }
}