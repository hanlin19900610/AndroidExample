package com.mufeng.roomdemo.db

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types.newParameterizedType
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


/**
 * @创建者 MuFeng-T
 * @创建时间 2019/11/21 11:28
 * @描述
 */
class TagConverters {

    @TypeConverter
    fun stringToObject(value: String): List<Tag>?{
        return value.toList()
    }
    @TypeConverter
    fun objectToString(list: List<Tag>): String{
        return list.toJson()
    }

}

inline fun <reified R>String.toObject(): R?{
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val jsonAdapter = moshi.adapter<R>(R::class.java)
    return jsonAdapter.fromJson(this)
}

inline fun <reified R>R.toJson(): String{
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val jsonAdapter = moshi.adapter<R>(R::class.java)
    return jsonAdapter.toJson(this)
}

inline fun <reified R>String.toList(): List<R>?{
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val listOfCardsType = newParameterizedType(List::class.java, R::class.java)
    val jsonAdapter = moshi.adapter<List<R>>(listOfCardsType)
    return jsonAdapter.fromJson(this)
}

inline fun <reified R>List<R>.toJson(): String{
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val listOfCardsType = newParameterizedType(List::class.java, R::class.java)
    val jsonAdapter = moshi.adapter<List<R>>(listOfCardsType)
    return jsonAdapter.toJson(this)
}


