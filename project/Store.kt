package project


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
        return this.listOfUsers.none { it.name.toLowerCase().contains(username.toLowerCase()) }
    }

    fun isInListOfUsersEmail(email: String): Boolean {
        return this.listOfUsers.none { it.email.toLowerCase().contains(email.toLowerCase()) }
    }
}