package tr.com.eywin.grooz.pinview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.view.children
import androidx.core.view.forEach
import tr.com.eywin.grooz.pinview.databinding.LayoutPinBinding

class PinView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttribute: Int = 0
) :
    LinearLayout(context, attrs, defStyleAttribute) {
    fun setPinClickedCallback(iOnPinClicked: IOnPinClicked) {
        b.root.children.forEach {
            if (it is LinearLayout)
                it.children.forEach {
                    if (it is PinItemView)
                        it.setPinClickedCallback(iOnPinClicked = iOnPinClicked)

                }
        }

    }

    var b = LayoutPinBinding.inflate(LayoutInflater.from(context), this, true)

}