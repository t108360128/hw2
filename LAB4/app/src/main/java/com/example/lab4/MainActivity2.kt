package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup

class MainActivity2 : AppCompatActivity() {
    private lateinit var set_drink: EditText
    private lateinit var rg1: RadioGroup
    private lateinit var rg2: RadioGroup
    private lateinit var btn_send: Button
    private var sugar: String = "無糖"
    private var ice_opt: String = "去冰"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        rg1 = findViewById(R.id.radioGroup)
        rg1.setOnCheckedChangeListener { _, i ->
            sugar = when (i) {
                R.id.radioButton -> "無糖"
                R.id.radioButton2 -> "少5糖"
                R.id.radioButton3 -> "半糖"
                R.id.radioButton4 -> "全糖"
                else -> "無糖" // 預設值
            }
        }

        rg2 = findViewById(R.id.radioGroup2)
        rg2.setOnCheckedChangeListener { _, i ->
            ice_opt = when (i) {
                R.id.radioButton5 -> "去冰"
                R.id.radioButton6 -> "微冰"
                R.id.radioButton7 -> "少冰"
                R.id.radioButton8 -> "正常冰"
                else -> "去冰" // 預設值
            }
        }

        btn_send = findViewById(R.id.btn_send)
        btn_send.setOnClickListener {
            set_drink = findViewById(R.id.ed_drink)
            val drink = set_drink.text.toString()
            val i = Intent()
            val b = Bundle()
            b.putString("drink", drink)
            b.putString("sugar", sugar)
            b.putString("ice", ice_opt)
            i.putExtras(b)
            setResult(RESULT_OK, i)
            finish()
        }
    }
}