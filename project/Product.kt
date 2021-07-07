package project

data class Product(
    val idProduct: Int,
    var name: String,
    var category: Category,
    var color: String,
    var price: Float,
    var quantity: Map<String,Int>,
) {
    var status = false

    init{

    }

    @JvmName("getIdProduct1")
    fun getIdProduct(): Int {
        return this.idProduct
    }

    @JvmName("getName1")
    fun getName(): String{
        return this.name.toString()
    }

    @JvmName("getPrice1")
    fun getPrice(): Float{
        return this.price.toFloat()
    }
}
