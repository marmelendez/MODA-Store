package project

class Store {
    private var catalogProduct = mutableListOf<Product>()
    var catalogCategory = mutableListOf<Category>()

    @JvmName("getCatalogProduct1")
    fun getProductNames(): List<String> {
        var newList = mutableListOf<String>()
        this.catalogProduct.forEach {
            newList.add(it.getName())
        }
        return newList
    }

    /*fun update() {
        println("---------- Menu ----------\n a) Categories b) Products")
        when(readLine().toString()){
            "a" -> {
                println("---------- Menu Category ----------\n" +
                        "a) Add category \n" +
                        "b) Remove category\n" +
                        "c) Modify existing category")
                when(readLine().toString()){
                    "a" -> addCategory()
                    "b" -> removeCategory()
                    "c" -> modifyCategory()
                    else -> println("Sorry not a valid option")
                }
            }
            "b" -> {
                println("---------- Menu Product ----------\n" +
                        "a) Add product \n" +
                        "b) Remove product\n" +
                        "c) Modify existing product")
                when(readLine().toString()){
                    "a" -> addProduct()
                    "b" -> removeProduct()
                    "c" -> modifyProduct()
                    else -> println("Sorry not a valid option")
                }
            }
            else -> println("Sorry, not a valid option")
        }
    }*/

    fun displayCategories() {
        println("---------- Categories ----------")
        catalogCategory.forEach {println(it.getName())}
    }

    fun displayProducts() {
        println("---------- Products ----------")
        this.catalogProduct.forEach {println(it.getName())}
    }

    private fun modifyCategory() {
        println("---------- Modify category ----------")
    }

    fun addCategory(category: Category) {
        this.catalogCategory.add(category)
        println("The category ${category.getName()} has been added to the catalog")
    }
    /*private fun addCategory() {
        var flag = true
        while (flag) {
            println("---------- Add category ----------")
            print("- ID: ")
            var id = readLine()?.toInt()
            print("- Name: ")
            var name = readLine().toString()
            var newCategory = id?.let { Category(it, name) }
            if (newCategory != null) {
                this.catalogCategory.add(newCategory)
            }
            print("Do you want to add another category? y/n: ")
            if (readLine().toString() == "n") {flag = false}
        }
        update()
    }*/

    private fun removeCategory(category: Category) {
        this.catalogCategory.remove(category)
        println("The category ${category.getName()} has been removed to the catalog")
    }

    fun addProduct(product: Product) {
        this.catalogProduct.add(product)
        println("The product ${product.getName()} has been added to the catalog")
    }

    /*private fun addProduct() {
        var flag = true
        while (flag) {
            println("---------- Add product ----------")
            print("- ID: ")
            var id = readLine()?.toInt()
            print("- Name: ")
            var name = readLine().toString()
            print("- Color: ")
            var color = readLine()?.toList()
            print("- Size: ")
            var size = readLine()?.toList()
            print("- Price: ")
            var price = readLine()?.toFloat()
            print("- Quantity: ")
            var quantity = readLine()?.toInt()
            //var newProduct = Product(id,name,color,size,price,quantity)

            print("Do you want to add another product? y/n: ")
            if (readLine().toString() == "n") {flag = false}
        }
        update()
    }*/

    private fun removeProduct(product: Product) {
        this.catalogProduct.remove(product)
        println("The product ${product.getName()} has been removed to the catalog")
    }

    private fun modifyProduct() {
        println("---------- Modify product ----------")
    }
}