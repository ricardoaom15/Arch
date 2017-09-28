package com.codemakers.archtest.ui.main

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.codemakers.archtest.R
import com.codemakers.archtest.data.model.Borrow
import com.codemakers.archtest.databinding.ActivityMainBinding
import com.codemakers.archtest.ui.adapters.BorrowAdapter
import com.jakewharton.rxbinding2.view.clicks
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView, Observer<List<Borrow>> {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    lateinit var adapter: BorrowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        adapter = BorrowAdapter()
        borrowList.layoutManager = LinearLayoutManager(this)
        borrowList.adapter = adapter

        viewModel.borrowList.observe(this, this)

    }

    override fun onClickAdd(): Observable<Unit> = addButton.clicks()

    override fun goToAdd() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onChanged(t: List<Borrow>?) {
        adapter.data = t!!
    }

}
