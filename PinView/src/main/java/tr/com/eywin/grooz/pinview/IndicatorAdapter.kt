package tr.com.eywin.grooz.pinview

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import tr.com.eywin.grooz.pinview.databinding.IndicatorItemBinding

class IndicatorAdapter(val pinCallback: (pin: String) -> Unit) :
    RecyclerView.Adapter<IndicatorAdapter.IndicatorViewHolder>() {
    var currentList = generateEmptyList()
    var pin: String = ""

    data class IndicatorItem(var isFilled: Boolean = false)
    inner class IndicatorViewHolder(val b: IndicatorItemBinding) : RecyclerView.ViewHolder(b.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        IndicatorViewHolder(IndicatorItemBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: IndicatorViewHolder, position: Int) {
        val context = holder.itemView.context
        holder.b.ind.setImageDrawable(
            if (!currentList[position].isFilled)
                getEmptyDrawable(context)
            else
                getFilledDrawable(context)
        )
    }

    fun fill(pin: Int) {
        if (currentList.count { it.isFilled } != currentList.size) {
            currentList.firstOrNull { !it.isFilled }?.let {
                it.isFilled = true
                this.pin += pin
                println("pin adapter -> ${this.pin}")
                notifyDataSetChanged()
                if (this.pin.length == 6)
                    pinCallback(this.pin)

            }
        } else {
            clear()
            fill(pin)
        }

    }

    fun delete() {
        if (currentList.count { !it.isFilled } != 0) {
            currentList.lastOrNull { it.isFilled }?.let {
                it.isFilled = false
                this.pin = this.pin.dropLast(1)
                notifyDataSetChanged()
            }
        } else
            clear()


    }

    fun clear() {
        currentList = generateEmptyList()
        this.pin = ""
        notifyDataSetChanged()
    }

    override fun getItemCount() = 6


    companion object {
        fun getEmptyDrawable(context: Context) =
            ContextCompat.getDrawable(context, R.drawable.ic_ind_empty)

        fun getFilledDrawable(context: Context) =
            ContextCompat.getDrawable(context, R.drawable.ic_ind_filled)

        fun generateEmptyList() = List(6) { IndicatorItem() }

    }

}