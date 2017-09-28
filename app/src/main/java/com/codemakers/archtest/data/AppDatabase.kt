package com.codemakers.archtest.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.codemakers.archtest.data.dao.BorrowDao
import com.codemakers.archtest.data.model.Borrow

@Database(entities = arrayOf(Borrow::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun borrowDao(): BorrowDao

}