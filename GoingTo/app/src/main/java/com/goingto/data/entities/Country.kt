package com.goingto.data.entities
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Country(
    @PrimaryKey
   val id: Int,

    @ColumnInfo
    val shortName: String,

    @ColumnInfo
    val fullName: String
    )



