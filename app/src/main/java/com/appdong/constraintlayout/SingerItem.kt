package com.appdong.constraintlayout

class SingerItem(var name: String?, var mobile: String?, var resId: Int?) {

	override fun toString(): String {
		return "SingerItem(name=$name, mobile=$mobile)"
	}
}
//원래 코드...코틀린은 primary constructor 설정으로 아래 과정(toString() 제외) 대체 가능
//class SingerItem {
//	var name:String? = null
//	var mobile:String? = null
//	var resId:Int? = null
//
//	constructor(name: String?, mobile: String?, resId: Int?) {
//		this.name = name
//		this.mobile = mobile
//		this.resId = resId
//	}
//}