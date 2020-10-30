package com.lintaostudy.kotlin.demo

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import androidx.core.view.get
import com.lintaostudy.kotlin.R
import com.lintaostudy.kotlin.demo.utils.HiDisplayUtil

/**
 * 自定义圆形指示器
 */
// 使用@JvmOverloads 注解完成多个构造方法的重载
class HiCircleIndicator @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), HiIndicator {
    /**
     * 选中的点
     */
    @DrawableRes
    private val mPointSelected = R.drawable.shape_point_select

    /**
     * 未选中的点
     */
    @DrawableRes
    private val mPointNormal = R.drawable.shape_point_normal

    //指示左右内间距
    private var mPointLeftRightPadding = 0

    // 上下内间距
    private var mPointTopBottomPadding = 0

    companion object {
        // 在伴生对象里实现静态成员
        private const val VWC = ViewGroup.LayoutParams.WRAP_CONTENT
    }

    // 次构造方法
    init {
        mPointLeftRightPadding = HiDisplayUtil.dp2px(5f, context.resources)
        mPointTopBottomPadding = HiDisplayUtil.dp2px(15f, context.resources)
    }

    override fun onPointChange(current: Int, count: Int) {
        val viewGroup = getChildAt(0) as ViewGroup
        for (i in 1 until viewGroup.childCount) {
            val img = viewGroup.getChildAt(i) as ImageView
            if (i == current) {
                img.setImageResource(mPointSelected)
            } else {
                img.setImageResource(mPointNormal)
            }
            img.requestLayout()
        }
    }

    override fun onInflate(count: Int) {
        removeAllViews()
        if (count <= 0)
            return
        val viewGroup = LinearLayout(context)
        viewGroup.orientation = LinearLayout.HORIZONTAL
        var img: ImageView
        val imgParas = LinearLayout.LayoutParams(VWC, VWC)
        imgParas.gravity = Gravity.CENTER_VERTICAL
        imgParas.setMargins(
            mPointLeftRightPadding,
            mPointTopBottomPadding,
            mPointLeftRightPadding,
            mPointTopBottomPadding
        )
        // 0-count in下边界,until上界
        for (i in 0 until count) {
            img = ImageView(context)
            img.layoutParams = imgParas
            if (i == 0) {
                img.setImageResource(mPointSelected)
            } else {
                img.setImageResource(mPointNormal)
            }
            viewGroup.addView(img)
            val groupParas = LinearLayout.LayoutParams(VWC, VWC)
            viewGroup.gravity = Gravity.CENTER or Gravity.BOTTOM
            addView(viewGroup, groupParas)
        }
    }

    override fun get(): FrameLayout {
        return this
    }

}

fun test(str: String) {
    if (str.isNullOrEmpty()) {// 判空

    } else if (str.isNullOrBlank()) {// 可以断是否含有空格(例如edittext输入)

    }
}