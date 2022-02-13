package com.appdong.constraintlayout

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val container = findViewById<FrameLayout>(R.id.container)
		val button = findViewById<Button>(R.id.button21)
		button.setOnClickListener { v ->
			val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
			inflater.inflate(R.layout.sub1, container, true)
		}
	}

}
