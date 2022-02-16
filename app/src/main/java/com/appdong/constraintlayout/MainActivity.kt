package com.appdong.constraintlayout

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
	var adapter: ListViewAdapter? = null
	var editText : EditText? = null
	var editText2: EditText? = null
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		editText = findViewById(R.id.editName)
		editText2 = findViewById(R.id.editMobile)
		val listView = findViewById<ListView>(R.id.listView)
		adapter = ListViewAdapter()
		adapter?.addItem(SingerItem("소녀시대", "010-1000-1000", R.drawable.pic1))
		adapter?.addItem(SingerItem("에프엑스", "010-2000-1000", R.drawable.pic2))
		adapter?.addItem(SingerItem("레드벨벳", "010-3000-1000", R.drawable.pic3))
		adapter?.addItem(SingerItem("에스파", "010-4000-1000", R.drawable.pic4))
		listView.adapter = adapter

		listView.setOnItemClickListener{ parent, view, position, id ->
			val item: SingerItem = adapter!!.getItem(position)
			Toast.makeText(applicationContext, item.name+" 선택", Toast.LENGTH_SHORT).show()
		}

		val button = findViewById<Button>(R.id.button23)
		button.setOnClickListener { v ->
			val name = editText?.text.toString()
			val mobile = editText2?.text.toString()

			adapter?.addItem(SingerItem(name, mobile, R.drawable.pic1))
			adapter?.notifyDataSetChanged()
		}
	}



}

