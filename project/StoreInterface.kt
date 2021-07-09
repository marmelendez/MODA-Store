package project

interface StoreInterface {
    val name: String
    val catalogProduct: MutableList<Product>
    val catalogCategory: MutableList<Category>
    val listOfUsers: MutableList<RegisteredUser>

    fun addCategory(category: Category)

    fun addProduct(product: Product)
}