## 이벤트 처리 방법
------
### 터치한 위치 구하기
----
 1. 뷰 변수 선언
    ex) 
```kotlin 
    view : View? = findViewById(R.id.view)
```
 2. 뷰에 OnTouchListener 설정
ex)
```kotlin 
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
```

### 제스처 구하기
---------
 1. GestureDetector 변수 선언 
  ex)
```kotlin 
	var detector : GestureDetector? = null
```
 2. 함수 설정
    ex)
```kotlin 
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
```
 3. 뷰에 적용
```kotlin 
    val view2 : View = findViewById(R.id.view2)
		view2.setOnTouchListener { v, event ->
			detector!!.onTouchEvent(event)
			true //or false
		}
```

### 누르면 그림 바뀌는 아이콘(xml에서 관리)
-------
```xml 
    <?xml version="1.0" encoding="utf-8"?>
    <selector xmlns:android="http://schemas.android.com/apk/res/android">
        <item
            android:state_focused="true"
            android:state_pressed="true"
            android:drawable="@drawable/red" />
        <item
            android:drawable="@drawable/blue" />
    </selector>
```

### 뒤로가기 눌렀을 때 Toast 메세지
---
 - onCreate() 밖에 함수 설정
```kotlin 
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
		if(keyCode == KeyEvent.KEYCODE_BACK){
			Toast.makeText(this, "시스템 Back 버튼 눌림", Toast.LENGTH_LONG).show()
			return true
		}
		return false
	}
```