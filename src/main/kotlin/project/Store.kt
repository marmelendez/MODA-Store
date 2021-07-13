package project

import java.util.*


class Store (override val name: String): StoreInterface {
    override val catalogProduct: MutableList<Product> = mutableListOf()
    override val catalogCategory: MutableList<Category> = mutableListOf()
    override val listOfUsers: MutableList<RegisteredUser> = mutableListOf()

    override fun addCategory(category: Category) {
        this.catalogCategory.add(category)
    }

    override fun addProduct(product: Product) {
        this.catalogProduct.add(product)
    }

    override fun addUser(user: RegisteredUser) {
        this.listOfUsers.add(user)
    }

    fun isInListOfUsersUsername(username: String): Boolean {
        // none: returns 'true' if the collection has no elements.
        return this.listOfUsers.none { it.getName().lowercase(Locale.getDefault()).contains(username.lowercase(Locale.getDefault())) }
    }

    fun isInListOfUsersEmail(email: String): Boolean {
        return this.listOfUsers.none { it.getEmail().lowercase(Locale.getDefault()).contains(email.lowercase(Locale.getDefault())) }
    }

    fun getUser(username: String): RegisteredUser? {
        var possibleUser = this.listOfUsers.filter{ it.getName() == username }
        return try {
            possibleUser[0]
        } catch(e: Exception) {
            null
        }
    }
}