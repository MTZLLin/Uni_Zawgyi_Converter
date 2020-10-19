package com.myanmarit.uni_zawgyi_converter

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.UserDictionary
import kotlinx.android.synthetic.main.activity_main.*
import me.myatminsoe.mdetect.MDetect
import me.myatminsoe.mdetect.Rabbit

class MainActivity : AppCompatActivity() {

    lateinit var typeface: Typeface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (MDetect.isUnicode()) run {
            this.typeface = MainApplication.typefaceManager.getUnicode()
            txtOne.text = Rabbit.uni2zg(getString(R.string.mm_uni))
            txttwo.text = Rabbit.zg2uni(getString(R.string.mm_zawgyi))
            txtOne.typeface = typeface
        }else run {
            this.typeface = MainApplication.typefaceManager.getZawgyi()
            //txtOne.text = Rabbit.zg2uni(R.string.mm_uni.toString())
            txtOne.text = Rabbit.zg2uni(getString(R.string.mm_uni))
            txtOne.typeface = typeface
        }

    }

}