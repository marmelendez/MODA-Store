package project

data class Category (val idCategory: Int,
                var name: String) {
    var products = mutableListOf<String>()

    @JvmName("getName1")
    fun getName(): String{
        return name
    }
}