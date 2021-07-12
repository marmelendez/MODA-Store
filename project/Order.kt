package project

class Order (var idOrder: Int,
             var total: Float,
             var addres: String,
             var orderDate: String) {

    init {
        println(""" Thanks for your purchase. 
                Detailed order:
                Order number: $idOrder
                Total Paid: $total
                Address: $addres
                Date: $orderDate
                """)
    }

}