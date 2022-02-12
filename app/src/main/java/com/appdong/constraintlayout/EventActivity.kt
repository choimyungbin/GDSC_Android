package com.appdong.constraintlayout

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.GestureDetector
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EventActivity : AppCompatActivity() {
	var textView : TextView? = null
	var detector : GestureDetector? = null
	@SuppressLint("ClickableViewAccessibility")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		textView = findViewById(R.id.textView)
		var view : View? = findViewById(R.id.view)

		view?.setOnTouchListener { v, event ->
			val action = event!!.action
			val curX = event.getX()
			val curY = event.getY()

			when (event?.action) {
				MotionEvent.ACTION_DOWN -> println("손가락 눌렸음 : $curX, $curY")
				MotionEvent.ACTION_MOVE -> println("손가락 움직임 : $curX, $curY")
				MotionEvent.ACTION_UP -> println("손가락 떼졌음 : $curX, $curY")
			}
			//리턴값이 false면 seekbar 동작 안됨
			true //or false
		}
		detector = GestureDetector(this, object : GestureDetector.OnGestureListener {
			override fun onDown(motionEvent: MotionEvent): Boolean {
				println("화면 눌림")
				return false
			}

			override fun onShowPress(motionEvent: MotionEvent) {
				println("화면 눌렀다 떼어짐")
			}

			override fun onSingleTapUp(motionEvent: MotionEvent): Boolean {
				println("화면을 한손으로 눌렀다 떼어짐")
				return false
			}

			override fun onScroll(
				motionEvent: MotionEvent,
				motionEvent1: MotionEvent,
				v: Float,
				v1: Float
			): Boolean {
				println("화면이 눌린채 일정한 속도와 방향으로 움직임 $v, $v1")
				return false
			}

			override fun onLongPress(motionEvent: MotionEvent) {
				println("화면을 손가락으로 오래 누름")
			}

			override fun onFling(
				motionEvent: MotionEvent,
				motionEvent1: MotionEvent,
				v: Float,
				v1: Float
			): Boolean {
				println("화면이 눌린채 가속도를 붙여 움직임 $v, $v1")
				return false
			}
		})

		val view2 : View = findViewById(R.id.view2)
		view2.setOnTouchListener { v, event ->
			detector!!.onTouchEvent(event)
			true //or false
		}
	}


	override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
		if(keyCode == KeyEvent.KEYCODE_BACK){
			Toast.makeText(this, "시스템 Back 버튼 눌림", Toast.LENGTH_LONG).show()
			return true
		}
		return false
	}

	public fun println (data : String) : Unit{
		textView?.append(data + "\n")
	}
}


