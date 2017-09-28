package com.codemakers.archtest.ui.adapters

import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.codemakers.archtest.R
import com.codemakers.archtest.data.model.Borrow
import com.codemakers.archtest.databinding.TemplateBorrowItemBinding
import com.codemakers.archtest.util.inflate
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by RicardoAndrés on 28/09/2017.
 */
class BorrowAdapter:
        RecyclerView.Adapter<BorrowAdapter.BorrowHolder>(){

    var data:List<Borrow> = emptyList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BorrowHolder, position: Int) {
        holder.binding.borrow = data[position]
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BorrowHolder
            = BorrowHolder(parent.inflate(R.layout.template_borrow_item))


    class BorrowHolder(view: View): RecyclerView.ViewHolder(view){
        val binding: TemplateBorrowItemBinding = DataBindingUtil.bind(view)
    }

    companion object {

        private val format = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())

        @JvmStatic
        @BindingAdapter("app:dateFormat")
        fun applyFormat(textView: TextView, date: Date){
            textView.text = format.format(date)
        }
    }
}