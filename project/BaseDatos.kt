package project

class BaseDatos {
    companion object Base {
        var category = mutableListOf<Category>()
        var shoppingCart = mutableListOf<Product>()
        val myStore = Store("MODA Store")

        var idProduct = 1
        var idUsers = 1
        var idCategory = 1

        fun iniciar(): Store {
            setCategory()
            setProducts()
            return this.myStore
        }

        fun setCategory() {
            myStore.addCategory(Category(idCategory++,"Dama"))
            myStore.addCategory(Category(idCategory++,"Caballero"))
        }

        fun setProducts() {
            var category = myStore.getCatalogCategory()
            //Dama
            myStore.addProduct(Product(idProduct++,"Blusa estampada",category[0],"Rosa",130F,mapOf("S" to 100, "M" to 50, "X" to 100)))
            myStore.addProduct(Product(idProduct++,"Blusa de tirantes",category[0],"Azul",300F, mapOf("S" to 100, "M" to 50, "X" to 100)))
            myStore.addProduct(Product(idProduct++,"Crop top con letras",category[0],"Negro",350F, mapOf("S" to 100, "M" to 50, "X" to 100)))
            myStore.addProduct(Product(idProduct++,"Vestido largo", category[0],"Rojo",900F, mapOf("S" to 100, "M" to 50, "X" to 100)))
            myStore.addProduct(Product(idProduct++,"Vestido de fiesta",category[0],"Azul",400F, mapOf("S" to 100, "M" to 50, "X" to 100)))
            myStore.addProduct(Product(idProduct++,"Short de mezclilla",category[0],"Azul claro",150F, mapOf("S" to 100, "M" to 50, "X" to 100)))
            myStore.addProduct(Product(idProduct++,"Falda de flores",category[0],"Amarilla",200F, mapOf("S" to 100, "M" to 50, "X" to 100)))
            myStore.addProduct(Product(idProduct++,"Pantalon de mezclilla",category[0],"Azul",350F, mapOf("S" to 100, "M" to 50, "X" to 100)))
            myStore.addProduct(Product(idProduct++,"Pantalon formal",category[0],"Negro",400F, mapOf("S" to 100, "M" to 50, "X" to 100)))
            myStore.addProduct(Product(idProduct++,"Top con cuello",category[0],"Blanco",150F, mapOf("S" to 100, "M" to 50, "X" to 100)))

            // Caballero
            myStore.addProduct(Product(idProduct++,"Playera con cuello",category[1],"Naranja",250F, mapOf("S" to 100, "M" to 50, "X" to 100)))
            myStore.addProduct(Product(idProduct++,"Pantalon de mezclilla",category[1],"Azul",400F, mapOf("S" to 100, "M" to 50, "X" to 100)))
            myStore.addProduct(Product(idProduct++,"Camisa con letras",category[1],"Negro",80F, mapOf("S" to 100, "M" to 50, "X" to 100)))
            myStore.addProduct(Product(idProduct++,"Pants",category[1],"Cafe",120F, mapOf("S" to 100, "M" to 50, "X" to 100)))
            myStore.addProduct(Product(idProduct++,"Bermuda",category[1],"Verde",250F, mapOf("S" to 100, "M" to 50, "X" to 100)))
            myStore.addProduct(Product(idProduct++,"Set pijama",category[1],"Azul marino",250F, mapOf("S" to 100, "M" to 50, "X" to 100)))
            myStore.addProduct(Product(idProduct++,"Camisa marvel",category[1],"Rojo",150F, mapOf("S" to 100, "M" to 50, "X" to 100)))
            myStore.addProduct(Product(idProduct++,"Pantalon pana",category[1],"Cafe",140F, mapOf("S" to 100, "M" to 50, "X" to 100)))
            myStore.addProduct(Product(idProduct++,"Pantalon traje",category[1],"Negro",320F, mapOf("S" to 100, "M" to 50, "X" to 100)))
            myStore.addProduct(Product(idProduct++,"Playera",category[1],"Gris",180F, mapOf("S" to 100, "M" to 50, "X" to 100)))
        }
    }


    /*fun setShoppingCart(listProducts : MutableList<Product>): MutableList<Product>{
        shoppingCart.add(listProducts[0])
        shoppingCart.add(listProducts[1])
        return shoppingCart
    }*/

    
/*    fun setUsers(shoppingCart: MutableList<Product>) : MutableList<RegisteredUser>{
        listUsers.add(RegisteredUser(idUsers++,"Tomas","tomas@gmail.com",
            "tomas123","Norte 56 No.4862, CDMX",shoppingCart))
        listUsers.add(RegisteredUser(idUsers++,"Jose","jose@gmail.com",
            "jose123","Sur 78 No.1135, CDMX",shoppingCart))
        listUsers.add(RegisteredUser(idUsers++,"Lizbeth","lizbeth@gmail.com",
            "lizbeth123","Oeste 46 No.25, Durango",shoppingCart))
        listUsers.add(RegisteredUser(idUsers++,"Didier","didier@gmail.com",
            "didier123","Este 56 No.63,Cancun",shoppingCart))
        listUsers.add(RegisteredUser(idUsers++,"","","","",shoppingCart))
        return listUsers
    }*/
}