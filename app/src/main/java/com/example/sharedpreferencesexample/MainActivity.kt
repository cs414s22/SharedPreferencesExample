package com.example.sharedpreferencesexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun saveData(view: View){

        // Create a SharedPreferences instance for edit
        val sharedPreferences = getPreferences(MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // save name
        editor.putString("name", name_text.text.toString())
        // save email
        editor.putString("email", email_text.text.toString())

        // apply changes -- DO NOT FORGET TO APPLY!!!
        editor.apply()

        Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()
    }


    fun loadData(view: View){

        // Create a SharedPreferences instance to retrieve data
        val sharedPreferences = getPreferences(MODE_PRIVATE)
        // Get name
        val name = sharedPreferences.getString("name", "")
        // Get email
        val email = sharedPreferences.getString("email", "")

        // Set the obtained values to editTexts
        name_text.setText(name)
        email_text.setText(email)

    }


    fun clear(view: View){

        // This method is pretty much the same as saveData method but
        // it clears/forgets the previously saved data

        // Create a shared preferences file for edit
        val sharedPreferences = getPreferences(MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // Clear the saved data (if previously saved )
        editor.clear()
        // apply changes
        editor.apply()

        // Clear the editTexts as well
        name_text.text.clear()
        email_text.text.clear()

        Toast.makeText(this, "Cleared!", Toast.LENGTH_SHORT).show()
    }
}