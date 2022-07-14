package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding : ActivityMainBinding
    private  val myName:MyName = MyName("Mostafa")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.myName=myName
        binding.buttonDone.setOnClickListener {
            addNickname(it)
        }


    }

    private fun addNickname(view: View) {

        binding.apply {
            myName?.nickName=txtName.text.toString()
            invalidateAll()
            txtName.visibility = View.GONE;
            textView.visibility = View.VISIBLE;
            buttonDone.visibility=View.GONE;
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }

}