package com.codemakers.archtest.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.codemakers.archtest.data.converters.DateConverter
import java.util.*

@Entity
class Borrow(@PrimaryKey(autoGenerate = true) var id: Long?,
             var itemName: String,
             var personName: String,
             @TypeConverters(DateConverter::class) var borrowDate: Date){

    @Ignore
    constructor(itemName: String, personName: String): this (null, itemName, personName, Date())
}
