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

    @JvmName("getCategory1")
    fun getCategory(): Category {
        return this.category
    }

    @JvmName("getPrice1")
    fun getPrice(): Float{
        return this.price.toFloat()
    }

    @JvmName("getColor1")
    fun getColor(): String {
        return this.color
    }

    @JvmName("getQuantity1")
    fun getQuantity(): Map<String, Int> {
        return this.quantity
    }
}
