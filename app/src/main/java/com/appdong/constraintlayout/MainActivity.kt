package com.appdong.constraintlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
	var imageView : ImageView? = null
	var imageView2 : ImageView? = null

	var index : Int = 0
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		//코틀린에서는 findViewById 생략가능
		imageView = findViewById(R.id.imageView)
		imageView2 = findViewById(R.id.imageView2)

	}

	public fun onButton10Clicked(v:View){
		index+=1
		if (index>1) {
			index=0
		}

		if(index==0){
			imageView?.setVisibility(View.VISIBLE)
			imageView2?.setVisibility(View.INVISIBLE)
		}else if (index==1){
			imageView?.setVisibility(View.INVISIBLE)
			imageView2?.setVisibility(View.VISIBLE)
		}
	}
}