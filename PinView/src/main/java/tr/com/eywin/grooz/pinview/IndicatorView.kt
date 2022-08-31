package tr.com.eywin.grooz.pinview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.view.children
import androidx.core.view.forEach
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tr.com.eywin.grooz.pinview.databinding.LayoutPinBinding

class IndicatorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttribute: Int = 0
) :
    RecyclerView(context, attrs, defStyleAttribute), IOnPinClicked {
    var iOnPinResult: IOnPinResult? = null
    val indicatorAdapter = IndicatorAdapter {
        println("pin -> $it")
        iOnPinResult?.onPinEntered(it)
    }

    fun setPinListener(iOnPinResult: IOnPinResult) {
        this.iOnPinResult = iOnPinResult
    }


    init {
        adapter = indicatorAdapter
        layoutManager = LinearLayoutManager(context, HORIZONTAL, false)
    }

    override fun getAdapter() = indicatorAdapter
    override fun onPinClicked(pin: Int) {
        if (pin == PinItemView.BACK_SPACE)
            adapter.delete()
        else
            adapter.fill(pin)
    }

    fun delete()  = adapter.delete()
    fun fill(pin:Int)  = adapter.fill(pin)
}