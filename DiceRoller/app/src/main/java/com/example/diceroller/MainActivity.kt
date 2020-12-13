package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView


class MainActivity : AppCompatActivity() {

//    intializing my variable references to interface
    //    the reason being we want to decrease the layout loading time when the app is in operation
//    we need to intialize our views here first using a method called lateint
//    this method promises kotlin that the  variable will be intialized before calling any operation on it
//    as below

    lateinit var diceImage: ImageView
    lateinit var btnRoll: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // first thing find your interface elements using the findviewbyid method
        diceImage = findViewById(R.id.diceImage)
        btnRoll = findViewById(R.id.btnRoll)

        //giving the button an onclick event
       btnRoll.setOnClickListener{
           rollDice()
       }

    }

    private fun rollDice() {
//        controlling my dice rolling
        //first thing get possible outcomes when the dice is rolled
        //we switch to random numbers using the java.util function called Random()
        val randomInt = java.util.Random().nextInt(6) + 1
        //calling the various image resource for each result
        val drawableResource = when(randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //finally select the correct image result for each spin case
        diceImage.setImageResource(drawableResource)


    }


}
