/*
A kotlin program to practise the implementation of lists in an common use case:
making orders in a restaurant.
 */

open class Item(val name: String, val price: Int)

class Noodles : Item("Noodles", 10){

    /*
    by default, printing an object instance always returns a string with the type and it's memory address.
    This function overrides the default to return only the name given as an argument
     */
    override fun toString(): String {
        return name
    }
}
/*
the vararg modifier is used to accept any number of toppings as argument
it only accepts arguments of the same type
 */
class Vegetables(vararg val toppings: String) : Item("Vegetables", 5){

    // returns a single string with all the chosen toppings
    override fun toString(): String {

        // gives an default topping if none is given in the constructor
        if (toppings.isEmpty()){
            return "$name: Alface"
        } else {
            return name + ": " + toppings.joinToString(", ")
        }
    }
}

class Order(val orderNumber: Int) {
    private val itemList = mutableListOf<Item>()
    
    //both addItem and addAll uses basic builder pattern 
    fun addItem(newItem: Item): Order {
        itemList.add(newItem)
        return this
    }
    
    fun addAll(newItems: List<Item>): Order {
        itemList.addAll(newItems)
        return this
    }
    
    fun print() {
        println("Number #$orderNumber")
        var total = 0
        for (item in itemList){
            println("${item}: $${item.price}")
            total += item.price
        }
        println("Total: $${total}")
    }
}

fun main() {

    // a list of orders need to be mutable because it's always growing
    val ordersList = mutableListOf<Order>()

    // makes the first two orders, adding items to it and placing it in the order list
    val order1 = Order(1)
    order1.addItem(Noodles())
    ordersList.add(order1)

    val order2 = Order(2)
    order2.addItem(Noodles())
    order2.addItem(Vegetables())
    ordersList.add(order2)

    // this order returns a list of toppings, that's why the addAll() is called
    val order3 = Order(3)
    val items = listOf(Noodles(), Vegetables("Carrots", "Beans", "Celery"))
    order3.addAll(items)
    ordersList.add(order3)


    val order4 = Order(4).addItem(Noodles()).addItem(Vegetables("Cabbage", "Onion"))
    ordersList.add(order4)

    // creating a order without a variable
    ordersList.add(
        Order(5)
            .addItem(Noodles())
            .addItem(Noodles())
            .addItem(Vegetables("Spinach")))

    // prints all the orders in the orders list
    for (order in ordersList) {
        order.print()
        println()
    }
}