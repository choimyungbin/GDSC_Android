package com.appdong.constraintlayout

class SingerItem {
	var name:String? = null
	var mobile:String? = null

	constructor(name: String?, mobile: String?) {
		this.name = name
		this.mobile = mobile
	}

	override fun toString(): String {
		return "SingerItem(name=$name, mobile=$mobile)"
	}

}