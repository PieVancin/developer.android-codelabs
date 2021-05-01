fun main() {
    
    // iterate with the while() loop
    val guestsPerFamily = listOf(2, 4, 1, 3)
    var totalGuests = 0
    var i = 0
    while (i < guestsPerFamily.size) {
        totalGuests += guestsPerFamily[i]
        i++
    }
    println("Total of guests: $totalGuests")
    
    // Iterate with the for() loop
    val names = listOf("Jessica", "Henry", "Alicia", "Jose")
    for (name in names) {
        println(name)
    }
}