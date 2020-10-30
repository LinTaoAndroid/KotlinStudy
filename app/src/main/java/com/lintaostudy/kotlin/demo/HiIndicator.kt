package com.lintaostudy.kotlin.demo

import android.widget.FrameLayout

 interface HiIndicator {
    fun onPointChange(current: Int, count: Int)
    fun onInflate(resId: Int)
    fun get(): FrameLayout
}