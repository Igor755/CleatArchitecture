package com.devcraft.clean_architecture.extension

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import android.text.TextUtils
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import android.widget.FrameLayout
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import com.devcraft.clean_architecture.R
import com.devcraft.domain.exception.NetworkErrorException
import com.devcraft.domain.exception.NotFoundException
import com.devcraft.domain.exception.RequestsLimitException
import com.devcraft.domain.exception.UnauthorizedException
import com.google.android.material.snackbar.Snackbar


@SuppressLint("ClickableViewAccessibility")
fun View.showError(message: String) {
    Snackbar.make(this, message, Snackbar.LENGTH_LONG).apply {
        view.background = context.getDrawable(R.drawable.snackbar_background)
        val params = view.layoutParams as MarginLayoutParams
        params.setMargins(12, 12, 12, 12)
        (params as? FrameLayout.LayoutParams)?.gravity = Gravity.TOP
        (params as? CoordinatorLayout.LayoutParams)?.gravity = Gravity.TOP
        view.layoutParams = params
        val tv = view.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        val endDrawable = resources.getDrawable(R.drawable.ic_baseline_close)
        tv.setCompoundDrawablesWithIntrinsicBounds(
            resources.getDrawable(R.drawable.ic_error_outline),
            null,
            endDrawable,
            null
        )
        tv.setOnTouchListener { v, event ->
            val bounds: Rect?
            if (event.action == MotionEvent.ACTION_DOWN) {
                if (event.rawX >= (tv.right - endDrawable.bounds.width())) {
                    dismiss()
                    return@setOnTouchListener true
                }
                return@setOnTouchListener false
            }
            return@setOnTouchListener false
        }
        tv.compoundDrawablePadding = resources.getDimensionPixelSize(R.dimen.offset_16)
        tv.setTextColor(resources.getColor(R.color.colorWhite))
        tv.isSingleLine = true
        tv.isSelected = true
        tv.gravity = Gravity.CENTER_VERTICAL
        tv.ellipsize = TextUtils.TruncateAt.MARQUEE
        tv.marqueeRepeatLimit = -1
        ViewCompat.setElevation(this.view, 6f)
        show()
    }
}


fun Context.getErrorMessageFromException(exception: Exception?, root  :View?, onBadUser : (() -> Unit)? = null, onNetworkError : (()-> Unit)) {
    when(exception) {
        is RequestsLimitException -> {
            root?.showError(resources.getString(R.string.you_have_reached_limit))
        }
        is NotFoundException -> {
            root?.showError(resources.getString(R.string.error_not_found))
        }
         is NetworkErrorException -> {
             onNetworkError.invoke()
         }
        is UnauthorizedException -> {
            onBadUser?.invoke()
        }
        else -> {
            exception?.message?.let { it1 ->
                root?.showError(
                    it1
                )
            }
        }
    }
}
