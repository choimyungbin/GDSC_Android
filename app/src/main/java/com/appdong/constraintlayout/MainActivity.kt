package com.appdong.constraintlayout

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
	private val button: AppCompatButton by lazy { findViewById(R.id.button28) }
	private val button2: AppCompatButton by lazy { findViewById(R.id.button29) }
	private val editText: AppCompatEditText by lazy { findViewById(R.id.editText) }
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		button.setOnClickListener{
			//Uri.parse로 전화 화면 불러오기
			val receiver = editText.text.toString()
			val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: $receiver"))
			startActivity(intent)

		}
		button2.setOnClickListener{
			//String으로 불러올 액티비티 지정 가능
			val intent2 = Intent()
			val name = ComponentName("com.appdong.constraintlayout", "com.appdong.constraintlayout.MenuActivity")
			intent2.component = name
			startActivity(intent2)
		}
	}
}

