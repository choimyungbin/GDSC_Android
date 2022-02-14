package com.appdong.constraintlayout

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView

class SingerItemView : LinearLayout {
	var textView : TextView? = null
	var textView2 : TextView? = null
	constructor(context: Context) : super(context){
		init(context)
	}
	constructor(context: Context, attrs: AttributeSet) : super(context, attrs){
		init(context)
	}
	private fun init(context: Context) {
		val inflater =context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
		inflater.inflate(R.layout.singer_item, this, true)
		textView = findViewById<TextView>(R.id.textView5)
		textView2 = findViewById<TextView>(R.id.textView6)

	}

	public fun setName(name : String) : Unit {
		textView?.text = name
	}
	public fun setMobile(mobile : String) : Unit {
		textView2?.text = mobile
	}
}