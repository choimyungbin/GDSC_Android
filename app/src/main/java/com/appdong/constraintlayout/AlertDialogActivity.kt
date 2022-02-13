package com.appdong.constraintlayout

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class AlertDialogActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val button = findViewById<Button>(R.id.button19)
		button.setOnClickListener { v ->
			showMessage()
		}
	}


	fun showMessage() : Unit {
		val builder = AlertDialog.Builder(this)
		val textView = findViewById<TextView>(R.id.textView2) //텍스트 표시를 위해 명목상 필요
		builder.setTitle("안내")
		builder.setMessage("종료하시겠습니까")
		builder.setIcon(android.R.drawable.ic_dialog_alert)

		builder.setPositiveButton("예"){ dialog, which ->
			Snackbar.make(textView, "예 버튼이 눌렸습니다", Snackbar.LENGTH_LONG).show()

		}
		builder.setNegativeButton("아니오"){dialog, which ->
			Snackbar.make(textView, "아니오 버튼이 눌렸습니다", Snackbar.LENGTH_LONG).show()
		}

		val dialog = builder.create()
		dialog.show()
	}
}
