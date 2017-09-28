package com.codemakers.archtest.data.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.codemakers.archtest.data.converters.DateConverter
import com.codemakers.archtest.data.model.Borrow
import android.arch.persistence.room.OnConflictStrategy.*

@Dao
@TypeConverters(DateConverter::class)
interface BorrowDao {

    @Insert(onConflict = REPLACE)
    fun insert(borrow: Borrow)

    @Delete
    fun delete(borrow: Borrow)

    @Query("SELECT * FROM borrow")
    fun getAll(): LiveData<List<Borrow>>

    @Query("SELECT * FROM borrow WHERE id = :id")
    fun getBorrowById(id: String): Borrow
}