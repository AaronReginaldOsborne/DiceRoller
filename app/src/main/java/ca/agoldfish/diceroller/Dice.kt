package ca.agoldfish.diceroller

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}