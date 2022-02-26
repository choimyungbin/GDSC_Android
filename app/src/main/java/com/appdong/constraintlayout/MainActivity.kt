package com.appdong.constraintlayout

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
	private val button: AppCompatButton by lazy { findViewById(R.id.button30) }
	lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
	var names = ArrayList<String>()
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		names.add("강영현")
		names.add("윤도운")
		activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
			if(it.resultCode == RESULT_OK){
				//code
			}
		}
		button.setOnClickListener{
			val intent = Intent(this, MenuActivity2::class.java)
			intent.putExtra("names",names)
			activityResultLauncher.launch(intent)
		}
	}
}

