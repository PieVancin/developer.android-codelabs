fun main() {
    // example of a list collection
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    println("list:   ${numbers}")
    println("sorted: ${numbers.sorted()}")
    
    // example of a set collection
    val setOfNumbers = numbers.toSet()
	println("set:    ${setOfNumbers}")
    
    val set1 = setOf(1,2,3)
    val set2 = mutableSetOf(3,2,1)

    // returns true because both have the same values, and the order doesn't matter
    println("$set1 == $set2: ${set1 == set2}")

    // checks if the set contains the number 7
    println("contains 7: ${setOfNumbers.contains(7)}")

    // example of a map collection, with a string as a key and a int as a value
    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30, 
        "Ann" to 23
    )

    // add a new key 
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51

    // overwrites the existing key
    peopleAges["Fred"] = 31
    println(peopleAges)
}