package com.example.komatqashv1

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SweetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sweet)
        val buttontocheckout: Button = findViewById(R.id.Checkout)
        buttontocheckout.setOnClickListener{
            val intent = Intent(this,Checkout::class.java)
            startActivity(intent)

        }
        //Chocolate Croissant
        val add11: Button = findViewById(R.id.add11)
        val sub11: Button = findViewById(R.id.sub11)
        val cnt11: TextView = findViewById(R.id.cnt11)
        add11.setOnClickListener{

            val values = ContentValues()
            values.put(CartContentProvider.ITEM, (findViewById<View>(R.id.itemName11) as TextView).text.toString())
            values.put(CartContentProvider.PRICE, "1.6")
            val uri = contentResolver.insert(
                CartContentProvider.CONTENT_URI, values
            )
            var value: Int = cnt11.text.toString().toInt();
            value += 1;
            cnt11.text = value.toString()
        }
        sub11.setOnClickListener{
            var c = contentResolver.delete(
                CartContentProvider.CONTENT_URI,
                "item=?", arrayOf((findViewById<View>(R.id.itemName11) as TextView).text.toString())
            )

            var value: Int = cnt11.text.toString().toInt();
            if(value != 0){
                value -= 1;
                while(c != 1){
                    val values = ContentValues()
                    values.put(CartContentProvider.ITEM, (findViewById<View>(R.id.itemName11) as TextView).text.toString())
                    values.put(CartContentProvider.PRICE, "1.6")
                    val uri = contentResolver.insert(
                        CartContentProvider.CONTENT_URI, values
                    )
                    c -= 1;
                }
            }
            cnt11.text = value.toString()
        }

        //Lotus Danish
        val add12: Button = findViewById(R.id.add12)
        val sub12: Button = findViewById(R.id.sub12)
        val cnt12: TextView = findViewById(R.id.cnt12)
        add12.setOnClickListener{
            var value: Int = cnt12.text.toString().toInt();
            value += 1;
            cnt12.text = value.toString()

            val values = ContentValues()
            values.put(CartContentProvider.ITEM, (findViewById<View>(R.id.itemName12) as TextView).text.toString())
            values.put(CartContentProvider.PRICE, "1.4")
            val uri = contentResolver.insert(
                CartContentProvider.CONTENT_URI, values
            )
        }
        sub12.setOnClickListener{
            var c = contentResolver.delete(
                CartContentProvider.CONTENT_URI,
                "item=?", arrayOf((findViewById<View>(R.id.itemName12) as TextView).text.toString())
            )

            var value: Int = cnt12.text.toString().toInt();
            if(value != 0){
                value -= 1;
                while(c != 1){
                    val values = ContentValues()
                    values.put(CartContentProvider.ITEM, (findViewById<View>(R.id.itemName12) as TextView).text.toString())
                    values.put(CartContentProvider.PRICE, "1.4")
                    val uri = contentResolver.insert(
                        CartContentProvider.CONTENT_URI, values
                    )
                    c -= 1;
                }
            }
            cnt12.text = value.toString()
        }

        //Cinnamon Roll
        val add13: Button = findViewById(R.id.add13)
        val sub13: Button = findViewById(R.id.sub13)
        val cnt13: TextView = findViewById(R.id.cnt13)
        add13.setOnClickListener{
            val values = ContentValues()
            values.put(CartContentProvider.ITEM, (findViewById<View>(R.id.itemName13) as TextView).text.toString())
            values.put(CartContentProvider.PRICE, "1.4")
            val uri = contentResolver.insert(
                CartContentProvider.CONTENT_URI, values
            )
            var value: Int = cnt13.text.toString().toInt();
            value += 1;
            cnt13.text = value.toString()
        }
        sub13.setOnClickListener{
            var c = contentResolver.delete(
                CartContentProvider.CONTENT_URI,
                "item=?", arrayOf((findViewById<View>(R.id.itemName13) as TextView).text.toString())
            )

            var value: Int = cnt13.text.toString().toInt();
            if(value != 0){
                value -= 1;
                while(c != 1){
                    val values = ContentValues()
                    values.put(CartContentProvider.ITEM, (findViewById<View>(R.id.itemName13) as TextView).text.toString())
                    values.put(CartContentProvider.PRICE, "1.4")
                    val uri = contentResolver.insert(
                        CartContentProvider.CONTENT_URI, values
                    )
                    c -= 1;
                }
            }
            cnt13.text = value.toString()
        }

        //Chocolate chip Cruffin
        val add14: Button = findViewById(R.id.add14)
        val sub14: Button = findViewById(R.id.sub14)
        val cnt14: TextView = findViewById(R.id.cnt14)
        add14.setOnClickListener{
            val values = ContentValues()
            values.put(CartContentProvider.ITEM, (findViewById<View>(R.id.itemName14) as TextView).text.toString())
            values.put(CartContentProvider.PRICE, "1.0")
            val uri = contentResolver.insert(
                CartContentProvider.CONTENT_URI, values
            )
            var value: Int = cnt14.text.toString().toInt();
            value += 1;
            cnt14.text = value.toString()
        }
        sub14.setOnClickListener{
            var c = contentResolver.delete(
                CartContentProvider.CONTENT_URI,
                "item=?", arrayOf((findViewById<View>(R.id.itemName14) as TextView).text.toString())
            )

            var value: Int = cnt14.text.toString().toInt();
            if(value != 0){
                while(c != 1){
                    val values = ContentValues()
                    values.put(CartContentProvider.ITEM, (findViewById<View>(R.id.itemName14) as TextView).text.toString())
                    values.put(CartContentProvider.PRICE, "1.0")
                    val uri = contentResolver.insert(
                        CartContentProvider.CONTENT_URI, values
                    )
                    c -= 1;
                }
                value -= 1;
            }
            cnt14.text = value.toString()
        }
    }
}