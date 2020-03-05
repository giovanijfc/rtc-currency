package com.example.rtc_currency.ui.view_model

import android.app.Application
import android.content.Context
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.rtc_currency.Preferences
import com.example.rtc_currency.database.models.Exchange
import com.example.rtc_currency.ui.view.StepsInfoActivity

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val context: Context = getApplication<Application>().applicationContext
    var exchanges = MutableLiveData<List<Exchange>?>()

    fun checkFirstInitializationApp() {
        val preferences = Preferences(context)
        val isFirstInitialization = preferences.isFirstInitialization()

        if (isFirstInitialization) {
            val stepsInfoIntent = Intent(context, StepsInfoActivity::class.java)
            stepsInfoIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            stepsInfoIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            context.startActivity(stepsInfoIntent)
        }
    }

    fun setExchanges(exchangesToUpdate: List<Exchange>) {
        exchanges = MutableLiveData(exchangesToUpdate)
    }
}