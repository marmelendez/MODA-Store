/*Un Data class es una clase que tiene como único objetivo cargar información en una
clase a través de su constructor, sin poder definir métodos para modificar o eliminar sus datos.*/


package project

data class Category (val idCategory: Int,
                     var name: String) {
    var products = mutableListOf<String>()

    @JvmName("getName1")
    fun getName(): String{
        return name
    }
}