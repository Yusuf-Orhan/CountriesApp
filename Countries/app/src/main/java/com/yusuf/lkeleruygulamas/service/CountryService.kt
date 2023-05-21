package com.yusuf.lkeleruygulamas.service

import com.yusuf.lkeleruygulamas.model.Country
import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class CountryService {
    //https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json
    private val BASE_URL ="https://raw.githubusercontent.com/"
    private val call = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(CountryApi::class.java)
    fun getData() : Single<List<Country>> {
        return call.getCountries()
    }
}