## 리스트뷰

 - 예시 화면

<img src = "https://user-images.githubusercontent.com/71762087/154292017-15fc8450-9410-4825-a23a-ed25b6cacb33.png" width="400px">

1. 전체 화면 구성

<img src = "https://user-images.githubusercontent.com/71762087/154292449-2459e351-9ced-42aa-b2f3-7b46cfa07a02.png" width="400px">
<img src = "https://user-images.githubusercontent.com/71762087/154292537-f85b5da4-3070-44a8-955a-4481b67f0273.png" width="400px">

2. item 뷰 구성

<img src = "https://user-images.githubusercontent.com/71762087/154292644-955746e2-3ef0-4d20-927d-66ed650b4955.png" width="400px">
<img src = "https://user-images.githubusercontent.com/71762087/154292676-6f1c8873-b445-4fff-811d-a83c6ba1a2ab.png" width="400px">

3. item 클래스 작성

```kotlin 
class SingerItem(var name: String?, var mobile: String?, var resId: Int?) {

	override fun toString(): String {
		return "SingerItem(name=$name, mobile=$mobile)"
	}
}
```
(코틀린은 primary 생성자를 인자처럼 작성할 수 있음)

4. 뷰와 아이템을 연결시킬 클래스 작성
 - 인플레이터 사용, 3의 아이템뷰와 연결
```kotlin 
class SingerItemView : LinearLayout {
	var textView : TextView? = null
	var textView2 : TextView? = null
	var imageView : ImageView? = null
	constructor(context: Context) : super(context){
		init(context)
	}
	constructor(context: Context, attrs: AttributeSet) : super(context, attrs){
		init(context)
	}
	private fun init(context: Context) {
		val inflater =context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
		inflater.inflate(R.layout.singer_item, this, true)
		textView = findViewById(R.id.textView5)
		textView2 = findViewById(R.id.textView6)
		imageView = findViewById(R.id.imageView4)
	}

	fun setName(name : String) {
		textView?.text = name
	}
	fun setMobile(mobile : String) {
		textView2?.text = mobile
	}
	fun setImage(resId: Int){
		imageView?.setImageResource(resId)
	}
}
```

5. 어댑터 클래스 작성
 - ArrayList를 관리
 - 어댑터는 데이터를 리스트뷰에 올림
```kotlin 
class ListViewAdapter : BaseAdapter() {	//BaseAdapter 를 상속한다는 뜻
	var items =  ArrayList<SingerItem>()	//코틀린은 new 사용하지 X
	// 크기 반환
	override fun getCount(): Int {
		return items.size
	}
	// 아이템 추가
	fun addItem(item: SingerItem){
		items.add(item)
	}
	fun removeItem(){
		items.removeAt(items.size - 1)
	}
	// 해당 아이템 반환
	override fun getItem(position: Int): SingerItem {
		return items[position] //items.get(position)
	}
	// 아이템의 id 반환
	override fun getItemId(position: Int): Long {
		return position.toLong()
	}

	// 뷰 반환
	override fun getView(position: Int, convertView: View?, parent: ViewGroup?): SingerItemView? {
		// 자바 코드
		// SingerItemView view = new SingerItemView(getApplicationContext());
		// val view = SingerItemView(parent!!.context) //이렇게도 쓸 수 있지만 재사용 불가.
		var view: SingerItemView? = null
		//코틀린은 조건에따라 수정할 변수를 if문 앞에 쓸 수 있음...!
		view = if(convertView == null){
			SingerItemView(parent!!.context)
		} else{
			convertView as SingerItemView?
		}
		val item = items[position]
		view?.setName(item.name!!)
		view?.setMobile(item.mobile!!)
		view?.setImage(item.resId!!)
		return view
	}
}
```

6. MainActivity 작성
 - 어댑터 객체 생성
 - 아이템 추가, 삭제 구현
```kotlin 
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
		val button2 = findViewById<Button>(R.id.button24)
		button.setOnClickListener { v ->
			val name = editText?.text.toString()
			val mobile = editText2?.text.toString()

			adapter?.addItem(SingerItem(name, mobile, R.drawable.pic1))
			adapter?.notifyDataSetChanged()
		}
		button2.setOnClickListener { v ->
			adapter?.removeItem()
			adapter?.notifyDataSetChanged()
		}
	}
}
```
