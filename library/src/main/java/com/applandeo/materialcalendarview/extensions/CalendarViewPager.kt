package com.applandeo.materialcalendarview.extensions

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

/**
 * Created by Mateusz Kornakiewicz on 21.11.2017.
 */

class CalendarViewPager @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null
) : ViewPager(context, attrs) {

    var swipeEnabled = true

    //This method is needed to get wrap_content height for ViewPager
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var heightMeasure = heightMeasureSpec
        var height = 0

        for (i in 0 until childCount) {
            val child = getChildAt(i)
            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED))

            val measuredHeight = child.measuredHeight

            if (measuredHeight > height) {
                height = measuredHeight
            }
        }

        if (height != 0) {
            heightMeasure = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY)
        }

        super.onMeasure(widthMeasureSpec, heightMeasure)
    }

    override fun onTouchEvent(event: MotionEvent) = swipeEnabled && super.onTouchEvent(event)

    override fun onInterceptTouchEvent(event: MotionEvent) = swipeEnabled && super.onInterceptTouchEvent(event)

}
