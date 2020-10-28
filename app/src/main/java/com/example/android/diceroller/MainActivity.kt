/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //Image container
    lateinit var catImage: ImageView

    //Variable that sets the toast method duration to long
    val duration = Toast.LENGTH_LONG

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Sets the layout about to use
        setContentView(R.layout.activity_main)

        //This text will appear in the toast message
        val text = getString(R.string.miau)
        //Create the toast message that will be shown in the given context
        val toast = Toast.makeText(applicationContext, text, duration)

        //Initialize a Button variable
        val changeButton: Button = findViewById(R.id.change_button)
        //Sets a listener that will press the button when we click on it
        changeButton.setOnClickListener {
            changeCat()
            //Shows the toast message
            toast.show()
        }

        catImage = findViewById(R.id.cat_image)
    }
    //Function rand requests two int arguments and returns us another
    fun rand(start: Int, end: Int): Int {
        //Throws an IllegalArgumentException if the value is false.
        require(start <= end) { "Illegal Argument"}
        //Randomize the int value returned between the given arguments
        return (start..end).random()
    }
    //Function changeCat use rand() to inicialize the drawable resources with one random picture
    private fun changeCat() {
        val randomInt = rand(1, 6)
        val drawableResource = when (randomInt) {
            1 -> R.drawable.gatito1
            2 -> R.drawable.gatito2
            3 -> R.drawable.gatito3
            4 -> R.drawable.gatito4
            5 -> R.drawable.gatito5
            else -> R.drawable.gatito6
        }
        //Set the image in its container
        catImage.setImageResource(drawableResource)
    }
}
