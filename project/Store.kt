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
        return this.listOfUsers.none { it.getName().toLowerCase().contains(username.toLowerCase()) }
    }

    fun isInListOfUsersEmail(email: String): Boolean {
        return this.listOfUsers.none { it.getEmail().toLowerCase().contains(email.toLowerCase()) }
    }

    fun isInListOfUsersPassword(password: String): Boolean {
        return this.listOfUsers.none { it.getPassword().toLowerCase().contains(password.toLowerCase()) }
    }

    fun getUser(username: String): RegisteredUser? {
        var posibleUser = this.listOfUsers.filter{ it.getName() == username }
        try {
            return posibleUser[0]
        } catch(e: Exception) {
            return null
        }
    }
}