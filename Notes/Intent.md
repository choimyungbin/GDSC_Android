## 화면 전환

### 늦은 초기화(lateinit, lazy)
~~이걸 왜 이제야 알았을까...~~
- 늦은 초기화란? 
  : null값을 지정하지 않고 초기화하는 방법. 자바에는 없는 형태이다.
- lateinit: null 없이 var을 선언할 때 사용. 
예시)
```kotlin 
lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
```  
  primitive type(Int, Boolean 등 코틀린에서 기본적으로 주는 타입)에 사용 불가, getter와 setter 사용 불가
  :변수명.isinitialized를 이용해 초기화된 상태인지 확인 가능
  예시)
```kotlin 
if(::변수명.isinitialized){
//코드 입력
}
```
- lazy: null 없이 val을 선언할 때 사용
예시)
```kotlin 
private val button: AppCompatButton by lazy { findViewById(R.id.button26) }
```  

###MainActivity

1. 버튼, textView, Intent 늦은 초기화
```kotlin 
	private val button: AppCompatButton by lazy { findViewById(R.id.button26) }
	private val textView: TextView by lazy { findViewById(R.id.textView8) }
	lateinit var activityResultLauncher: ActivityResultLauncher<Intent>
```
2. 다음 액티비티에서 불러올 값 작성
```kotlin 
		activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
			if(it.resultCode == RESULT_OK){
				val name = it.data?.getStringExtra("name")
				textView.text = name
				Toast.makeText(applicationContext, "응답: $name", Toast.LENGTH_SHORT).show()
			}
		}
```
 - registerForActivityResult는 다른 액티비티에서 값을 받을 때 사용.
 - resultCode라는 속성을 다음 액티비티로부터 받아올 건데,
   해당 속성이 RESULT_OK일 경우 특정 String을 받아오도록 설정
 - 여기서는 "name"이라는 태그의 값을 name이라는 변수에 가져온 후, textView에 띄우고 토스트로 알려줌
   ("name"과 그에 해당하는 값은 딕셔너리처럼 작용)

3. 버튼을 눌렀을 때 화면 불러오기
```kotlin 
		button.setOnClickListener {
			val intent = Intent(this, MenuActivity::class.java)
			activityResultLauncher.launch(intent)
		}
```
 - Intent 객체 생성, Context와 띄울 액티비티 설정
 - 액티비티 띄우기

###MenuActivity

1. 버튼 생성
```kotlin 
	private val button: AppCompatButton by lazy{findViewById(R.id.button27)}
```
2. contentView를 다음 액티비티로 수정
```kotlin 
		setContentView(R.layout.activity_menu)
```
3. 버튼 눌렀을 때 돌아가기
```kotlin 
		button.setOnClickListener{ v ->
			val intent = Intent(this, MainActivity::class.java).apply {
				putExtra("name","mark")
			}
			setResult(RESULT_OK, intent)
			finish()
		}
```
 - putExtra로 "name" 이름에 "mark"라는 String 반환하도록 설정
 - Result를 RESULT_OK로 설정
 - finish()로 이전화면 돌아가기