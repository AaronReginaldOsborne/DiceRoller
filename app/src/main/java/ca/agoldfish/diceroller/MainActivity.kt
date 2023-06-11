package ca.agoldfish.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logging()
        //division()
        // Do a dice roll when the app starts
        rollDice()

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    fun logging() {
        Log.e(TAG, "Hello, world!")
        Log.w(TAG, "This oven does not heat evenly. You may want to turn the cake around halfway through to promote even browning.")
        Log.i(TAG, "The cake is ready to be served.")
        Log.d(TAG, "Cake was removed from the oven after 55 minutes. Recipe calls for the cake to be removed after 50 - 60 minutes.")
        Log.v(TAG, "Put the mixing bowl on the counter.")
    }

//    fun division() {
//        val numerator = 60
//        var denominator = 4
//        repeat(5) {
//            Log.v(TAG, "${numerator / denominator}")
//            denominator--
//        }
//    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }


}