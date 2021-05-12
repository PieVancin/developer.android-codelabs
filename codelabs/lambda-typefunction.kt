fun main() {
    val triple: (Int) -> Int = { a: Int -> a * 3 }
		// or: val triple: (Int) -> Int = { it * 3 }
        // because it only have a single parameter
    println(triple(5))
}