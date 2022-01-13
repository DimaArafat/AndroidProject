package com.example.komatqashv1
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper




class MainActivity : AppCompatActivity() {
    private var db: SQLiteDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        var c = contentResolver.delete(
            CartContentProvider.CONTENT_URI,
            null, null
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttontonextpage: Button = findViewById(R.id.button)

        buttontonextpage.setOnClickListener{
            val intent = Intent(this,MenuActivity1::class.java)
            startActivity(intent)
        }
    }
}