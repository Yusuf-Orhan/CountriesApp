package com.yusuf.lkeleruygulamas.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yusuf.lkeleruygulamas.model.Country
import com.yusuf.lkeleruygulamas.view.Singeton

class DetailsViewModel : ViewModel() {
    val SelectedCountry = MutableLiveData<Country>()
    fun loadingData(){
        val country = Country("Turkey","Ankara","Asia","TRY","www.sss.com","TURKISH")
        SelectedCountry.value = Singeton.country
    }
}