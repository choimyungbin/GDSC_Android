package com.appdong.constraintlayout

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val listView = findViewById<ListView>(R.id.listView)
	}

	class SingerAdaptor : BaseAdapter(){
		var items =  ArrayList<SingerItem>()
		override fun getCount(): Int {
			return items.size
		}

		override fun getItem(position: Int): Any {
			return items[position] //items.get(position)
		}

		override fun getItemId(position: Int): Long {
			return position as Long
		}

//		override fun getView(position: Int, convertView: View?, parent: ViewGroup?): Unit {
//
//		}

	}
}
