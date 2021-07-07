package Proyecto

class Order (val idOrder: Int,
             var total: Float,
             var addres: String,
             val orderDate: String) {

    init {
        println(""" Gracias Por su compra. 
                Orden detallada:
                Orden Numero: $idOrder
                Total a Pagar: $total
                Direccion: $addres
                Fecha: $orderDate
                """)
    }
}