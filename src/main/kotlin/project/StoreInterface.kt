package project

import project.Product
import project.RegisteredUser


interface StoreInterface {
    val name: String
    val catalogProduct: MutableList<Product>
    val catalogCategory: MutableList<Category>
    val listOfUsers: MutableList<RegisteredUser>

    fun addCategory(category: Category)

    fun addProduct(product: Product)

    fun addUser(user: RegisteredUser)
}