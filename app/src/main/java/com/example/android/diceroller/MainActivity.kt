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
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var catImage: ImageView


    val duration = Toast.LENGTH_LONG

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = getString(R.string.miau)
        val toast = Toast.makeText(applicationContext, text, duration)

        val changeButton: Button = findViewById(R.id.change_button)
        changeButton.setOnClickListener {
            rollDice()
            toast.show()
        }

        catImage = findViewById(R.id.cat_image)
    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6) + 1
        val drawableResource = when (randomInt) {
            1 -> R.drawable.gatito1
            2 -> R.drawable.gatito2
            3 -> R.drawable.gatito3
            4 -> R.drawable.gatito4
            5 -> R.drawable.gatito5
            else -> R.drawable.gatito6
        }

        catImage.setImageResource(drawableResource)
    }
}
