package project;

class RegisteredUser(
        idUser: String,
        name: String,
        email: String,
        password: String): GuestUser(idUser){

        @JvmName("getName1")
        fun getName(): String {
                return this.name
        }

        /*override val email: String
                get() {
                        return this.email
                }

        fun getPassword(): String {
                return this.password
        }*/

        private fun addToCart(product: Product) {
                println("The product ${product.getName()} has been added to your cart")
                this.shoppingCart.add(product)
        }

        fun removeFromCart(product: Product) {
                println("The product ${product.getName()} has been removed to your cart")
                this.shoppingCart.remove(product)
        }

        fun makePurchase() {
                println("---------- Purchase ----------")
                var total = 0F
                shoppingCart.forEach() {
                        println(" - ${it.getName()}\t $ ${it.getPrice()}")
                        total += it.getPrice()
                }
                var iva = total * 0.16F
                println("Subtotal: $ ${total}\nIVA: ${iva}\nTotal a pagar: ${total + iva}")
        }

        fun makeRefund(idRefund: String) {
                this.devolutions.add(idRefund)
        }
}


