package com.appdong.constraintlayout

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SpinnerActivity : AppCompatActivity() {
	var textview: TextView? = null
	var items = arrayOf("소녀시대","에프엑스","레드벨벳","에스파")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val spinner = findViewById<Spinner>(R.id.spinner)
		textview = findViewById(R.id.textView7)
		//adapter 객체 생성
		var adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items)
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
		spinner.adapter = adapter

		//OnItemSelectedListener 설정. 형태 외우기
		spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
			override fun onItemSelected(
				parent: AdapterView<*>?,
				view: View?,
				position: Int,
				id: Long
			) {
				textview?.text = items[position]
			}

			override fun onNothingSelected(parent: AdapterView<*>?) {
				textview?.text = ("선택: ")
			}
		}
	}
}

