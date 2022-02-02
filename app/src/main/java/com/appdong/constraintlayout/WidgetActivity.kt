package com.appdong.constraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RadioButton

class WidgetActivity : AppCompatActivity() {
	var radioButton : RadioButton? = null
	var checked : Boolean? = null
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		radioButton = findViewById(R.id.radioButton)
		checked = radioButton?.isChecked()
	}
}