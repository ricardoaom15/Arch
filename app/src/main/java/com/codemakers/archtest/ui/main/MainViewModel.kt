package com.codemakers.archtest.ui.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Room
import com.codemakers.archtest.data.AppDatabase
import com.codemakers.archtest.data.model.Borrow
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by RicardoAndrés on 28/09/2017.
 */
class MainViewModel(application: Application): AndroidViewModel(application) {

    var borrowList: LiveData<List<Borrow>>
    val appDatabase: AppDatabase
            = Room.databaseBuilder(application, AppDatabase::class.java, "borrow.db").build()

    init {
        borrowList = appDatabase.borrowDao().getAll()
    }

    fun deleteItem(borrow: Borrow){
        appDatabase.borrowDao().delete(borrow)
    }




}