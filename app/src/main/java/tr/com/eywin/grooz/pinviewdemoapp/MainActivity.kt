package tr.com.eywin.grooz.pinviewdemoapp

import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import tr.com.eywin.grooz.pinview.IOnPinClicked
import tr.com.eywin.grooz.pinview.IndicatorAdapter
import tr.com.eywin.grooz.pinview.PinItemView
import tr.com.eywin.grooz.pinview.PinView
import tr.com.eywin.grooz.pinviewdemoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), IOnPinClicked {
    var b: ActivityMainBinding? = null
    val adapter = IndicatorAdapter {
        println("pin -> $it")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        b?.pinView?.setPinClickedCallback(this)
        b?.recycler?.adapter = adapter
    }

    override fun onPinClicked(pin: Int) {
        if (pin == PinItemView.BACK_SPACE)
            adapter.delete()
        else
            adapter.fill(pin)
    }
}