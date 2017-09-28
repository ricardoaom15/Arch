package com.codemakers.archtest.data.converters

import android.arch.persistence.room.TypeConverter
import java.util.*

/**
 * Created by RicardoAndrés on 28/09/2017.
 */
object DateConverter {

    @TypeConverter
    @JvmStatic
    fun dateToLong(date: Date): Long = date.time

    @TypeConverter
    @JvmStatic
    fun longToDate(timestamp: Long): Date = Date(timestamp)

}