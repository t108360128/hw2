package com.example.lab4

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tv_meal: TextView
    private lateinit var btn_select: Button

    private val mStartForResult: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent: Intent? = result.data
                if (intent != null && intent.extras != null) {
                    val b: Bundle? = intent.extras
                    val str1: String? = b?.getString("drink")
                    val str2: String? = b?.getString("sugar")
                    val str3: String? = b?.getString("ice")
                    tv_meal.text = String.format("飲料: %s\n\n甜度: %s\n\n冰塊 %s", str1, str2, str3)
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_meal = findViewById(R.id.tv_meal)
        btn_select = findViewById(R.id.btn_choice)
        btn_select.setOnClickListener {
            mStartForResult.launch(
                Intent(this, MainActivity2::class.java)
            )
        }
    }
}