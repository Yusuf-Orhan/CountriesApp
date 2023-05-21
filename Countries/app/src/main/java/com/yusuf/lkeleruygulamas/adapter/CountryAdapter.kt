package com.yusuf.lkeleruygulamas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.yusuf.lkeleruygulamas.R
import com.yusuf.lkeleruygulamas.model.Country
import com.yusuf.lkeleruygulamas.util.downloadFromUri
import com.yusuf.lkeleruygulamas.view.MainFragmentDirections
import com.yusuf.lkeleruygulamas.view.Singeton
import kotlinx.android.synthetic.main.country_row.view.*

class CountryAdapter(val arrayList: ArrayList<Country>) : RecyclerView.Adapter<CountryAdapter.MyHolder>(){
    class MyHolder(var itemView : View) : RecyclerView.ViewHolder(itemView){
        val textView : TextView = itemView.findViewById(R.id.name)
        val card : CardView = itemView.findViewById(R.id.cardView)
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_row,parent,false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int){
       // holder.itemView.CountryNameText.setText(arrayList[position].name)
        holder.textView.text = arrayList[position].name
        holder.imageView.downloadFromUri(arrayList[position].flag)
        holder.card.setOnClickListener {
            Singeton.country = arrayList[position]
            val action = MainFragmentDirections.actionMainFragment2ToDetailsFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
    fun updateCountryList(newList : List<Country>){
        arrayList.clear()
        arrayList.addAll(newList)
        notifyDataSetChanged()
    }

}