package tr.com.eywin.grooz.pinview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import tr.com.eywin.grooz.pinview.databinding.LayoutPinBinding
import tr.com.eywin.grooz.pinview.databinding.LayoutPinItemBinding

class PinItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttibute: Int = 0,
) :
    ConstraintLayout(context, attrs, defStyleAttibute) {
    companion object {
        const val BACK_SPACE = -1
        const val EMPTY = -2
    }

    fun setPinClickedCallback(iOnPinClicked: IOnPinClicked) {
        this.callback = iOnPinClicked
    }

    val number = context.obtainStyledAttributes(attrs, R.styleable.PinItemView)
        .getInt(R.styleable.PinItemView_number, EMPTY)

    private var callback: IOnPinClicked? = null
    var b = LayoutPinItemBinding.inflate(LayoutInflater.from(context), this, true).also { binding ->
        binding.root.setOnClickListener {
            callback?.onPinClicked(number)
        }


    }

    init {
        attrs?.let {
            val obtainStyledAttributes =
                context.obtainStyledAttributes(attrs, R.styleable.PinItemView)
            val number = obtainStyledAttributes.getInt(R.styleable.PinItemView_number, EMPTY)
            val resId = getResIdFromNumber(number)
            resId?.let {
                b.pinImage.setImageDrawable(ContextCompat.getDrawable(context, it))

            }

        }
    }

    private fun getResIdFromNumber(number: Int) = when (number) {
        BACK_SPACE -> R.drawable.ic_backspace
        0 -> R.drawable.ic_num_0
        1 -> R.drawable.ic_num_1
        2 -> R.drawable.ic_num_2
        3 -> R.drawable.ic_num_3
        4 -> R.drawable.ic_num_4
        5 -> R.drawable.ic_num_5
        6 -> R.drawable.ic_num_6
        7 -> R.drawable.ic_num_7
        8 -> R.drawable.ic_num_8
        9 -> R.drawable.ic_num_9
        else -> null
    }

}