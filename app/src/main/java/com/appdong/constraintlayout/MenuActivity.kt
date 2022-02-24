package com.appdong.constraintlayout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MenuActivity : AppCompatActivity() {
	private val button: AppCompatButton by lazy{findViewById(R.id.button27)}
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_menu)

		button.setOnClickListener{ v ->
			val intent = Intent(this, MainActivity::class.java).apply {
				putExtra("name","mark")
			}
			setResult(RESULT_OK, intent)
			finish()
		}
	}

}