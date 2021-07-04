package project

class Category (val idCategory: Int,
                var name: String) {
    var products = mutableListOf<String>()

    @JvmName("getId1")
    fun getId(): Int{
        return idCategory
    }
    @JvmName("getName1")
    fun getName(): String{
        return name
    }
}