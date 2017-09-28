package com.codemakers.archtest

import android.app.Application
import android.arch.persistence.room.Room
import com.codemakers.archtest.data.AppDatabase

class App: Application(){

    val appDatabase: AppDatabase
            = Room.databaseBuilder(this, AppDatabase::class.java, "borrow.db").build()

}