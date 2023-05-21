package com.yusuf.lkeleruygulamas.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.core.content.pm.ShortcutInfoCompatSaver.NoopImpl
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yusuf.lkeleruygulamas.MainActivity
import com.yusuf.lkeleruygulamas.model.Country
import com.yusuf.lkeleruygulamas.service.CountryService
import com.yusuf.lkeleruygulamas.view.MainFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {
    private val countryService = CountryService()
    private val compositeDisposable = CompositeDisposable()
    val countries = MutableLiveData<ArrayList<Country>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()
    fun refreshData(){
        getDataFromApi()
    }
    fun getDataFromApi(){
        countryLoading.value = true
        compositeDisposable.add(countryService.getData().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<Country>>(){
                override fun onSuccess(list : List<Country>) {
                    countryLoading.value = false
                    countries.value = ArrayList(list)
                }

                override fun onError(e: Throwable) {
                    countryError.value = true
                    countryLoading.value =false
                    println("Error : ${e.localizedMessage}")
                }

            }))

    }
    fun getDataFromSQLite(){

    }
    private fun handleResponse(countryList : List<Country>){
        println("Veriler Geldi")
    }
}