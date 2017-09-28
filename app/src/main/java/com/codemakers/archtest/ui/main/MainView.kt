package com.codemakers.archtest.ui.main

import io.reactivex.Observable

interface MainView{

    fun onClickAdd(): Observable<Unit>
    fun goToAdd()
}