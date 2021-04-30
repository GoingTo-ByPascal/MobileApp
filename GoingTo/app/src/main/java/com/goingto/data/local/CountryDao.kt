package com.goingto.data.local

import androidx.room.Query
import com.goingto.data.entities.Country

interface CountryDao {

    @Query("select * from country")
    fun getAll(): MutableList<Country>

    @Query("select * from country where id = :id")
    fun findById(id: Int): Country

}