package com.example.komatqashv1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu1)
        val buttontosweet: Button = findViewById(R.id.sweetbutton)
        buttontosweet.setOnClickListener{
            val intent = Intent(this,SweetActivity::class.java)
            startActivity(intent)

        }
        val buttontosavory: Button = findViewById(R.id.savorybutton)
        buttontosavory.setOnClickListener{
            val intent = Intent(this,SavoryActivity::class.java)
            startActivity(intent)

        }
    }
}