package com.example.komatqashv1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class Checkout : AppCompatActivity() {
        var startservicebtn:Button?= null
        var stopservicebtn:Button?= null
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_checkout)




            Toast.makeText(this,"hello", Toast.LENGTH_SHORT).show()


            setContentView(R.layout.activity_checkout)
            val startservicebtn:Button = findViewById(R.id.confirm)
            val stopservicebtn:Button = findViewById(R.id.cancel)
            val text = "We're sorry to see you go"
            startservicebtn.setOnClickListener(View.OnClickListener { startService()
            var dialog_var = CustomDialogclass()
            dialog_var.show(supportFragmentManager, "Custom Dialog")
            })
            stopservicebtn.setOnClickListener(View.OnClickListener { stopService()
                Toast.makeText(this,text, Toast.LENGTH_LONG).show()
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            })
        }


        fun startService() {
        val serviceIntent = Intent(this, ForegroundService::class.java)
        serviceIntent.putExtra("inputExtra", "Thank you for ordering from Komat Qash!")
        ContextCompat.startForegroundService(this, serviceIntent)
         }
        fun stopService() {
        val serviceIntent = Intent(this, ForegroundService::class.java)
        stopService(serviceIntent)
    }

    override fun onStart() {
        super.onStart()

        val uri = contentResolver.query(
            CartContentProvider.CONTENT_URI,null,null,null,null
        )
        val total : TextView = findViewById(R.id.totalPrice)
        total.text = "Total Price = " + CartContentProvider.TOTAL
    }

}
