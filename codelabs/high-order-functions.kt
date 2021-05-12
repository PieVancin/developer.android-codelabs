    fun main() {
    val peopleNames = listOf("Fred", "Ann", "Barbara", "Joe")
    println(peopleNames.sorted())

    // high-order sortedWith function that returns the names in order of increasing length
    println(peopleNames.sortedWith { str1: String, str2: String -> str1.length - str2.length })
}