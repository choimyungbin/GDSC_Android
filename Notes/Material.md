## 토스트, 스낵바 띄우기
-----
![Toast.png](Toast.png)
 - 토스트 : 짧은 메시지를 전달하는 팝업
![Snackbar.png](Snackbar.png)   
 - 스낵바 : 짧은 메시지를 띄우고, 옆에 클릭 액션도 추가 가능

### 토스트

```kotlin 
		val button = findViewById<Button>(R.id.toastButton)
		button.setOnClickListener { v ->
			val toast = makeText(this, "위치가 바뀐 토스트", Toast.LENGTH_LONG)
			toast.setGravity(Gravity.TOP or Gravity.START, 200, 200)
			toast.show()
		}
```

### 토스트 커스텀
```kotlin 
		val button2 = findViewById<Button>(R.id.changeButton)
		button2.setOnClickListener { v ->
			val inflater = layoutInflater
			val layout = inflater.inflate(R.layout.toastborder, findViewById(R.id.toast_layout_root))
			val text = layout.findViewById<TextView>(R.id.textToast)
			text.text = "모양을 바꾼 토스트"

			val toast = Toast(applicationContext) //new 필요 x
			toast.setGravity(Gravity.CENTER, 0, -100)
			toast.duration = Toast.LENGTH_LONG
			toast.view = layout

			toast.show()
		}
```
### 스낵바
 - build.gradle(:app)에서
  implementation 'com.google.android.material:material:1.5.0' 추가! 
 - File -> Project Structure 에서 Dependency -> Library Dependency 중
   com.google.android.material:material 추가!
```kotlin 
		val button3 = findViewById<Button>(R.id.button20)
		button3.setOnClickListener { v ->
			var snackbar = Snackbar.make(v, "스낵바입니다", Snackbar.LENGTH_LONG)
			snackbar.show()
		}
```   