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
}