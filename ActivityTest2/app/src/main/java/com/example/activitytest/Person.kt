package com.example.activitytest

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

//class Person: Parcelable {
//    var name = ""
//    var age = 0
//
//    override fun writeToParcel(dest: Parcel?, flags: Int) {
//        dest?.writeString(name)
//        dest?.writeInt(age)
//    }
//
//    override fun describeContents(): Int {
//        return  0
//    }
//
//    companion object CREATOR : Parcelable.Creator<Person> {
//        override fun createFromParcel(source: Parcel?): Person {
//            val person = Person()
//            person.name = source?.readString() ?: "" //读取数据
//            person.age = source?.readInt() ?: 0
//            return person
//        }
//
//        override fun newArray(size: Int): Array<Person?> {
//            return arrayOfNulls(size)
//        }
//    }
//}


@Parcelize
class Person(var name: String, var ag: Int): Parcelable
