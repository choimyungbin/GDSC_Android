package com.appdong.constraintlayout

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

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
		//조건에따라 수정할 변수를 if문 앞에 쓸 수 있음...!
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