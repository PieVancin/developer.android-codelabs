fun main() {
    val entrees = mutableListOf<String>()
    // or val entrees: MutableList<String> = mutableListOf()
    
    // Add items with add()
    println("Add noodles: ${entrees.add("noodles")}")
    println("Entrees: $entrees")
    println("Add spaghetti: ${entrees.add("spaghetti")}")
    println("Entrees: $entrees")
    
    // Add a list of items with addAll()
    val moreItems = listOf("ravioli", "lasagna", "fettuccine")
    println("Add list: ${entrees.addAll(moreItems)}")
    println("Entrees: $entrees")
    
    // Removing items with remove()
    println("Remove spaghetti: ${entrees.remove("spaghetti")}")
    println("Entrees: $entrees")
    println("Remove item that doesn't exist: ${entrees.remove("rice")}")
	println("Entrees: $entrees")
    
    // Remove items with removeAt()
    println("Remove first element: ${entrees.removeAt(0)}")
	println("Entrees: $entrees")
    
    // Clear out the list
    entrees.clear()
	println("Entrees: $entrees")
    
    // Check if the list is empty
    println("Empty? ${entrees.isEmpty()}")
}