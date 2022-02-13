## 비트맵 버튼 만들기

1. xml 파일 설정

```kotlin 
    <com.appdong.constraintlayout.BitmapButton
        android:id="@+id/textView3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="TextView"
        />
```

2. BitmapButton 코틀린파일 작성
 - AppCompatButton import해오기
```kotlin 
import androidx.appcompat.widget.AppCompatButton
```
 - 생성자 정의
```kotlin 
constructor(context: Context) : super(context) {
		init(context)
	}
	constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
		init(context)
	}
```
 - init 설정
```kotlin 
private fun init(context: Context) {
		setBackgroundResource(R.drawable.title_bitmap_button_normal)
		val textSize = resources.getDimension(R.dimen.text_size) //res>values>dimens에 저장해놓은 16dp 불러옴
		setTextSize(textSize)
		setTextColor(Color.YELLOW)
	}
```
 - 함수 추가
```kotlin 
	override fun onTouchEvent(event: MotionEvent): Boolean {
		val action = event.action
		when (action) {
			MotionEvent.ACTION_DOWN -> setBackgroundResource(R.drawable.title_bitmap_button_clicked)
			MotionEvent.ACTION_UP -> setBackgroundResource(R.drawable.title_bitmap_button_normal)
		}
		invalidate()	//다시 그리기
		return true
	}
```