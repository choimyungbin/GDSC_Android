package com.appdong.constraintlayout

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class InflaterActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val container = findViewById<FrameLayout>(R.id.container)
		val button = findViewById<Button>(R.id.button21)
		val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

		button.setOnClickListener { v ->
			inflater.inflate(R.layout.sub1, container, true)
			val button2 = findViewById<Button>(R.id.button22)
			button2.setOnClickListener { v ->
				container.removeAllViews()
			}
		}


	}

}
