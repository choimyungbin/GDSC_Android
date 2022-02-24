package com.appdong.constraintlayout

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView

class IntentActivity : AppCompatActivity() {
	private val button: AppCompatButton by lazy { findViewById(R.id.button26) }
	private val textView: AppCompatTextView by lazy { findViewById(R.id.textView8) }
	lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
			if(it.resultCode == RESULT_OK){
				val name = it.data?.getStringExtra("name")
				textView.text = name
				Toast.makeText(applicationContext, "응답: $name", Toast.LENGTH_SHORT).show()
			}
		}
		button.setOnClickListener {
			val intent = Intent(this, MenuActivity::class.java)
			activityResultLauncher.launch(intent)
		}
	}
}

