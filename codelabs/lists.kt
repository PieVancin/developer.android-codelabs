fun main() {
    val numbers = listOf (1, 2, 3, 4, 5, 6)
    println("List: $numbers")
    println("Size: ${numbers.size}")

    // access elements of the list
    println("First element: ${numbers[0]}")
    println("Second element: ${numbers[1]}")
    println("Last index: ${numbers.size - 1}")
	println("Last element: ${numbers[numbers.size - 1]}")
    println("First: ${numbers.first()}")
	println("Last: ${numbers.last()}")

    // Use the contains() method to know if a element is on the list
    println("Contains 4? ${numbers.contains(4)}")
	println("Contains 7? ${numbers.contains(7)}")

    val colors = listOf("green", "orange", "blue")
    println("====colors====")
    println("Reversed list: ${colors.reversed()}")
    println("List: $colors")
    println("Sorted list: ${colors.sorted()}")
}