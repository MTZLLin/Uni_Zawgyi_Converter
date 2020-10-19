package com.myanmarit.uni_zawgyi_converter.utils

import android.app.ActivityManager
import android.content.Context
import android.content.Context.ACTIVITY_SERVICE
import android.content.res.AssetManager
import android.graphics.Typeface
import android.util.LruCache

class TypefaceManager {
    companion object {
        val PYIDAUNGSU = "pyidaungsu.ttf"
        val ZAWGYI = "zawgyi_one.ttf"
    }

    lateinit var assetManager: AssetManager
    lateinit var activityManager: ActivityManager
    lateinit var mCache: LruCache<String, Typeface>

    constructor(manager: AssetManager, context: Context) {
        this.assetManager = manager
        activityManager = context.getSystemService(ACTIVITY_SERVICE) as ActivityManager
        // val availMemo = activityManager.memoryClass
        val availMemo = 4 * 1024 * 1024  //4 * 10^6 = 4 Gigabyte (Cache memory)
        mCache = LruCache(availMemo)

    }

    fun getTypeface(filename: String): Typeface {
    var  typeface: Typeface? = mCache.get(filename)
        if (typeface == null){
            typeface = Typeface.createFromAsset(assetManager, filename)
        }
        return  typeface!!
    }
        fun getUnicode(): Typeface{
        return getTypeface(PYIDAUNGSU)
        }
        fun getZawgyi(): Typeface{
        return getTypeface(ZAWGYI)
        }

}