package project


class Store (val name: String){
    private var catalogProduct = mutableListOf<Product>()
    var catalogCategory = mutableListOf<Category>()

    @JvmName("getName1")
    fun getName(): String {
        return this.name
    }

    @JvmName("getCatalogCategory1")
    fun getCatalogCategory(): MutableList<Category> {
        return this.catalogCategory
    }

    fun getCatalogProduct(): MutableList<Product> {
        return this.catalogProduct
    }

    @JvmName("getCatalogProduct1")
    fun getProductNames(): List<String> {
        var newList = mutableListOf<String>()
        this.catalogProduct.forEach {
            newList.add(it.getName())
        }
        return newList
    }

    fun displayCategories() {
        println("---------- Categories ----------")
        catalogCategory.forEach {println(it.getName())}
    }

    fun displayProducts() {
        println("---------- Products ----------")
        this.catalogProduct.forEach {println(it.getName())}
    }

    fun addCategory(category: Category) {
        this.catalogCategory.add(category)
    }

    fun addProduct(product: Product) {
        this.catalogProduct.add(product)
    }
}