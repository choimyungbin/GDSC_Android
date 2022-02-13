package com.appdong.constraintlayout

import android.os.Bundle
import android.text.Layout
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class ToastActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val button = findViewById<Button>(R.id.toastButton)
		button.setOnClickListener { v ->
			val toast = makeText(this, "위치가 바뀐 토스트", Toast.LENGTH_LONG)
			toast.setGravity(Gravity.TOP or Gravity.START, 200, 200)
			toast.show()
		}
		val button2 = findViewById<Button>(R.id.changeButton)
		button2.setOnClickListener { v ->
			val inflater = layoutInflater
			val layout = inflater.inflate(R.layout.toastborder, findViewById(R.id.toast_layout_root))
			val text = layout.findViewById<TextView>(R.id.textToast)
			text.text = "모양을 바꾼 토스트"

			val toast = Toast(applicationContext) //new 필요 x
			toast.setGravity(Gravity.CENTER, 0, -100)
			toast.duration = Toast.LENGTH_LONG
			toast.view = layout

			toast.show()
		}
		val button3 = findViewById<Button>(R.id.button20)
		button3.setOnClickListener { v ->
			var snackbar = Snackbar.make(v, "스낵바입니다", Snackbar.LENGTH_LONG)
			snackbar.show()
		}
	}


}


