package com.yusuf.lkeleruygulamas.room

import androidx.room.Dao
import androidx.room.Insert
import com.yusuf.lkeleruygulamas.model.Country

@Dao
interface CountryDao {
    @Insert
    suspend fun insert(vararg country: Country) : List<Long>
    @androidx.room.Query("SELECT * FROM Countries")
    suspend fun getAllCountries() : List<Country>
    @androidx.room.Query("SELECT * FROM Countries WHERE uuid = :countryId")
    suspend fun getCountry(countryId : Int) : List<Country>
    @androidx.room.Query("DELETE FROM Countries")
    suspend fun deleteAllCountries()
}