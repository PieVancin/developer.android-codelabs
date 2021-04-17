import kotlin.math.PI
import kotlin.math.sqrt

/* 
A program to practise the implementation of class hierarchy, variables and function inheritance, 
using as example a abstraction of some kinds of dwelling.
 */

// initialize the implemented dwellings
fun main() {
	val squareCabin = SquareCabin(6, 50.0)
    val roundHut = RoundHut(3, 10.0)
    val roundTower = RoundTower(4, 15.5)
    
    /*
    "with" blocks are used to access the properties and methods without the need of hardcoding
    the object name in every line
    */
    with(squareCabin) {
    	println("\nSquare Cabin\n============")
   		println("Capacity: ${capacity}")
    	println("Material: ${buildingMaterial}")
    	println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
    }
  
    with(roundHut) {
        println("\nRound Hut\n============")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Floor area: %.2f".format(floorArea()))
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }
    
    with(roundTower) {
        println("\nRound Tower\n==========")
    	println("Material: ${buildingMaterial}")
    	println("Capacity: ${capacity}")
    	println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }
}


// a abstraction of a common dwelling, receive as parameter the number of residents
abstract class Dwelling(private var residents: Int) {
    
    abstract val buildingMaterial: String
    abstract val capacity: Int
    
    // verify if the dwelling has a room available
    fun hasRoom(): Boolean {
        return residents < capacity
    }
    
    // adds a resident if there's a available room, and prints the result
    fun getRoom() {
        if (residents < capacity) {
            residents++
            println("You've got a room!")
        } else {
            println("There's no room available.")
        }
    }
    
    // declare a abstract function to be implemented
    abstract fun floorArea(): Double
}

// a child of dwelling, receives as parameter the number of residents and the length to calculate floor area
class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
    
    override val buildingMaterial = "Wood"
    override val capacity = 6
    
    override fun floorArea(): Double {
        return length * length
    }
}

/*
another child of dwelling, but now receives the radius value, because it's a round building.
this class will have a child, so it's needed to specify that it's a open class, because all the classes
are final by default.
 */
open class RoundHut(
    residents: Int, 
    val radius: Double) : Dwelling(residents) {
    
    override val buildingMaterial = "Straw"
    override val capacity = 4
    
    override fun floorArea(): Double {
        return PI * radius * radius
    }
    
    // a new function that will have to be implemented on it's child too
    fun calculateMaxCarpetSize(): Double {
        val diameter = 2 * radius
        return sqrt(diameter * diameter / 2)
    }
}

// the child of RoundHut, that receives the number of floors as an parameter
class RoundTower(
    residents: Int,
    radius: Double,
    val floors: Int = 2) : RoundHut(residents, radius) {
    
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors
    
    /*
    now the area needs to be multiplied by the number of floors.
    the function returns the floor area value using the parent method, using the super. syntax
    and multiplying it by the number of floors
    */
    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}