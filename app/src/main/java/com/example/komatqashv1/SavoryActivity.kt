package com.example.komatqashv1

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SavoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_savory)
        val buttontocheckout: Button = findViewById(R.id.Checkout)
        buttontocheckout.setOnClickListener {
            val intent = Intent(this, Checkout::class.java)
            startActivity(intent)

        }
        //Chocolate Croissant
        val add21: Button = findViewById(R.id.add21)
        val sub21: Button = findViewById(R.id.sub21)
        val cnt21: TextView = findViewById(R.id.cnt21)
        add21.setOnClickListener{
            Toast.makeText(baseContext, "hello", Toast.LENGTH_LONG).show()

            val values = ContentValues()
            values.put(CartContentProvider.ITEM, (findViewById<View>(R.id.itemName21) as TextView).text.toString())
            values.put(CartContentProvider.PRICE, "1.5")
            val uri = contentResolver.insert(
                CartContentProvider.CONTENT_URI, values
            )
            Toast.makeText(baseContext, uri.toString(), Toast.LENGTH_LONG).show()
            var value: Int = cnt21.text.toString().toInt();
            value += 1;
            cnt21.text = value.toString()
        }
        sub21.setOnClickListener{
            var c = contentResolver.delete(
                CartContentProvider.CONTENT_URI,
                "item=?", arrayOf((findViewById<View>(R.id.itemName21) as TextView).text.toString())
            )

            var value: Int = cnt21.text.toString().toInt();
            if(value != 0){
                value -= 1;
                while(c != 1){
                    val values = ContentValues()
                    values.put(CartContentProvider.ITEM, (findViewById<View>(R.id.itemName21) as TextView).text.toString())
                    values.put(CartContentProvider.PRICE, "1.5")
                    val uri = contentResolver.insert(
                        CartContentProvider.CONTENT_URI, values
                    )
                    c -= 1;
                }
            }
            cnt21.text = value.toString()
        }

        //Lotus Danish
        val add22: Button = findViewById(R.id.add22)
        val sub22: Button = findViewById(R.id.sub22)
        val cnt22: TextView = findViewById(R.id.cnt22)
        add22.setOnClickListener{
            var value: Int = cnt22.text.toString().toInt();
            value += 1;
            cnt22.text = value.toString()

            val values = ContentValues()
            values.put(CartContentProvider.ITEM, (findViewById<View>(R.id.itemName22) as TextView).text.toString())
            values.put(CartContentProvider.PRICE, "1.9")
            val uri = contentResolver.insert(
                CartContentProvider.CONTENT_URI, values
            )
        }
        sub22.setOnClickListener{
            var c = contentResolver.delete(
                CartContentProvider.CONTENT_URI,
                "item=?", arrayOf((findViewById<View>(R.id.itemName22) as TextView).text.toString())
            )

            var value: Int = cnt22.text.toString().toInt();
            if(value != 0){
                value -= 1;
                while(c != 1){
                    val values = ContentValues()
                    values.put(CartContentProvider.ITEM, (findViewById<View>(R.id.itemName22) as TextView).text.toString())
                    values.put(CartContentProvider.PRICE, "1.9")
                    val uri = contentResolver.insert(
                        CartContentProvider.CONTENT_URI, values
                    )
                    c -= 1;
                }
            }
            cnt22.text = value.toString()
        }

        //Cinnamon Roll
        val add23: Button = findViewById(R.id.add23)
        val sub23: Button = findViewById(R.id.sub23)
        val cnt23: TextView = findViewById(R.id.cnt23)
        add23.setOnClickListener{
            val values = ContentValues()
            values.put(CartContentProvider.ITEM, (findViewById<View>(R.id.itemName23) as TextView).text.toString())
            values.put(CartContentProvider.PRICE, "1.5")
            val uri = contentResolver.insert(
                CartContentProvider.CONTENT_URI, values
            )
            var value: Int = cnt23.text.toString().toInt();
            value += 1;
            cnt23.text = value.toString()
        }
        sub23.setOnClickListener{
            var c = contentResolver.delete(
                CartContentProvider.CONTENT_URI,
                "item=?", arrayOf((findViewById<View>(R.id.itemName23) as TextView).text.toString())
            )

            var value: Int = cnt23.text.toString().toInt();
            if(value != 0){
                value -= 1;
                while(c != 1){
                    val values = ContentValues()
                    values.put(CartContentProvider.ITEM, (findViewById<View>(R.id.itemName23) as TextView).text.toString())
                    values.put(CartContentProvider.PRICE, "1.5")
                    val uri = contentResolver.insert(
                        CartContentProvider.CONTENT_URI, values
                    )
                    c -= 1;
                }
            }
            cnt23.text = value.toString()
        }

        //Chocolate chip Cruffin
        val add24: Button = findViewById(R.id.add24)
        val sub24: Button = findViewById(R.id.sub24)
        val cnt24: TextView = findViewById(R.id.cnt24)
        add24.setOnClickListener{
            val values = ContentValues()
            values.put(CartContentProvider.ITEM, (findViewById<View>(R.id.itemName24) as TextView).text.toString())
            values.put(CartContentProvider.PRICE, "0.9")
            val uri = contentResolver.insert(
                CartContentProvider.CONTENT_URI, values
            )
            var value: Int = cnt24.text.toString().toInt();
            value += 1;
            cnt24.text = value.toString()
        }
        sub24.setOnClickListener{
            var c = contentResolver.delete(
                CartContentProvider.CONTENT_URI,
                "item=?", arrayOf((findViewById<View>(R.id.itemName24) as TextView).text.toString())
            )

            var value: Int = cnt24.text.toString().toInt();
            if(value != 0){
                while(c != 1){
                    val values = ContentValues()
                    values.put(CartContentProvider.ITEM, (findViewById<View>(R.id.itemName24) as TextView).text.toString())
                    values.put(CartContentProvider.PRICE, "0.9")
                    val uri = contentResolver.insert(
                        CartContentProvider.CONTENT_URI, values
                    )
                    c -= 1;
                }
                value -= 1;
            }
            cnt24.text = value.toString()
        }
    }
}