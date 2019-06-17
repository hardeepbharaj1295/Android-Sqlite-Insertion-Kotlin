package com.hardeep.androidkotlininsertion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.hardeep.androidkotlininsertion.database.DatabaseQueries

class MainActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var number : EditText
    lateinit var address: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.name)
        number = findViewById(R.id.number)
        address = findViewById(R.id.address)
    }

    fun addCustomer(v:View)
    {
        val db = DatabaseQueries(this)
        val result = db.addCustomer(name.text.toString(),number.text.toString(),address.text.toString())
        if (result>0)
        {
            Toast.makeText(this,"Inserted",Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(this,"Error",Toast.LENGTH_LONG).show()
        }
    }
}
