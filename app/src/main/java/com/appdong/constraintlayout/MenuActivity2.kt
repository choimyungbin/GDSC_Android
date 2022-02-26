package com.appdong.constraintlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import java.util.ArrayList

class MenuActivity2 : AppCompatActivity() {
	private val button: AppCompatButton by lazy{ findViewById(R.id.button31)}
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_menu2)

		button.setOnClickListener{
			finish()
		}
		val passedIntent = intent
		processIntent(passedIntent)
	}
	private fun processIntent(intent: Intent){
		@Suppress("UNCHECKED_CAST")
		val names = intent.getSerializableExtra("names") as ArrayList<String>
		Toast.makeText(applicationContext, "전달받은 이름 리스트 개수: "+names.size, Toast.LENGTH_SHORT).show()
	}
}