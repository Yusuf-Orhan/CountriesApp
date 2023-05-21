package com.yusuf.lkeleruygulamas.service

import com.yusuf.lkeleruygulamas.model.Country
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface CountryApi {
    //https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json
    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    fun getCountries() : Single<List<Country>>

}