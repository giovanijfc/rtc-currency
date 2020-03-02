package com.example.rtc_currency.ui.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rtc_currency.R
import com.example.rtc_currency.database.models.Exchange
import kotlinx.android.synthetic.main.adapter_exchange_item.view.*

class ExchangesItemListAdapter(
    private val exchanges: List<Exchange>,
    private val context: Context
) :
    RecyclerView.Adapter<ExchangesItemListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val exchangeItemView =
            LayoutInflater.from(context).inflate(R.layout.adapter_exchange_item, parent, false)

        return ViewHolder(exchangeItemView)
    }


    override fun onBindViewHolder(exchangeItemAdapterView: ViewHolder, position: Int) {
        val exchange = exchanges.get(position)

        exchangeItemAdapterView?.textName.text = exchange.name!!.replace("/ /g", "")
        exchangeItemAdapterView?.textRank.text = exchange.trustScoreRank.toString()
        exchangeItemAdapterView?.yearFoundedIn.text =
            if (exchange.yearEstablised == null) "N/A" else exchange.yearEstablised.toString()
        exchangeItemAdapterView?.live_at.text =
            if (exchange.country == null) "N/A" else exchange.country.toString()
    }

    override fun getItemCount(): Int {
        return exchanges.size
    }

    class ViewHolder(exchangeItemAdapterView: View) :
        RecyclerView.ViewHolder(exchangeItemAdapterView) {
        val textName = exchangeItemAdapterView.text_name
        val imageLogo = exchangeItemAdapterView.image_logo
        val textRank = exchangeItemAdapterView.text_rank
        val yearFoundedIn = exchangeItemAdapterView.text_year_founded
        val live_at = exchangeItemAdapterView.text_live_at
        val imageFavorite = exchangeItemAdapterView.image_favorite
    }
}