# 인텐트

[화면 전환 기초](##화면-전환-기초)
[화면 전환 & 클래스 전달](##화면-전환-&-클래스-전달)

## 화면 전환 기초

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
 - ActivityResultLauncher: 액티비티에서 데이터를 받아옴. 
   (원래 이 역할을 하던 ActivityForResult 대신 사용) 
   현재 ActivityForResult는 메모리 부족 문제 때문에 안드로이드에서 deprecated 됨)
   
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




##화면 전환 & 클래스 전달

###MainActivity
```kotlin 
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
```
 - ArrayList 생성, 요소 추가
 - OnClickListener에서, "names"라는 태그로 names 객체 전달
 - 나머지는 기초 부분과 동일

 ### MenuActivity2

 ```kotlin 
class MenuActivity2 : AppCompatActivity() {
	private val button: AppCompatButton by lazy{ findViewById(R.id.button31)}
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_menu2)

		button.setOnClickListener{
			finish()
		}
		val passedIntent = intent
		processIntent(passedIntent)
	}
	private fun processIntent(intent: Intent){
		@Suppress("UNCHECKED_CAST")
		val names = intent.getSerializableExtra("names") as ArrayList<String>
		Toast.makeText(applicationContext, "전달받은 이름 리스트 개수: "+names.size, Toast.LENGTH_SHORT).show()
	}
}
 ```
 - 코틀린은 getIntent() 대신 intent만 써도 불러와진다...
 - processIntent라는 함수 생성, names를 serializable로 불러와 ArrayList로 형변환
 - **serializable: 객체의 직렬화**
    : 객체의 내용을 바이트 단위로 바꾸어 파일/네트워크를 통해 전달할 수 있게 함
 - 마지막으로 토스트에 리스트의 항목 개수를 표시하게 함