package tr.com.eywin.grooz.pinviewdemoapp

import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import tr.com.eywin.grooz.pinview.*
import tr.com.eywin.grooz.pinviewdemoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), IOnPinClicked {
    var b: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        b?.pinView?.setPinClickedCallback(this)
        b?.indicatorView?.setPinListener(object :IOnPinResult{
            override fun onPinEntered(pin: String) {

            }

        })
    }

    override fun onPinClicked(pin: Int) {
        if (pin == PinItemView.BACK_SPACE)
            b?.indicatorView?.delete()
        else
            b?.indicatorView?.fill(pin)
    }
}