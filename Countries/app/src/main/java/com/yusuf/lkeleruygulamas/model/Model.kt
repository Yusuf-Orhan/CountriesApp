package com.yusuf.lkeleruygulamas.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Currency
@Entity("Countries")
data class Country(
    @ColumnInfo( "Country_Name")
    val name : String,
    @ColumnInfo("Country_Capital")
    val capital : String,
    @ColumnInfo("Country_Region")
    val region : String,
    @ColumnInfo("Country_Currency")
    val currency : String,
    @ColumnInfo("Country_Flag")
    val flag : String,
    @ColumnInfo("Country_Language")
    val language : String
    ){
    @PrimaryKey(autoGenerate = true)
    val uuid : Int = 0
}