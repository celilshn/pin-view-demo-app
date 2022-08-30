package tr.com.eywin.grooz.pinview

import android.os.Build
import android.util.TypedValue
import android.view.View
import android.widget.ViewSwitcher
import androidx.core.content.ContextCompat

fun ViewSwitcher.switch(view: View?) {
    if (nextView.id == view?.id)
        showNext()
}
fun View.addBackgroundRipple() = with(TypedValue()) {
    context.theme.resolveAttribute(android.R.attr.selectableItemBackground, this, true)
    setBackgroundResource(resourceId)
}

fun View.addBackgroundCircleRipple() = with(TypedValue()) {
    context.theme.resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, this, true)
    setBackgroundResource(resourceId)
}

fun View.addForegroundRipple() = with(TypedValue()) {
    context.theme.resolveAttribute(android.R.attr.selectableItemBackground, this, true)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        foreground = ContextCompat.getDrawable(context, resourceId)
    }
}

fun View.addForegroundCircleRipple() = with(TypedValue()) {
    context.theme.resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, this, true)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        foreground = ContextCompat.getDrawable(context, resourceId)
    }
}
 fun View.disable() {
    isClickable = false
    isFocusable = false
    isEnabled = false

}

 fun View.enable() {
    isClickable = true
    isFocusable = true
    isEnabled = true
}
