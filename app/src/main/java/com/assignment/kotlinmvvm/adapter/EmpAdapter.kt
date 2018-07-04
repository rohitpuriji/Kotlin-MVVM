package com.assignment.trainenquiry.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.assignment.kotlinmvvm.DataModel.Android
import com.assignment.kotlinmvvm.MainActivity
import com.assignment.kotlinmvvm.R
import com.assignment.kotlinmvvm.interfaces.ItemClickListener
import com.jakewharton.rxbinding.view.RxView
import com.jakewharton.rxbinding.widget.RxTextView
import kotlinx.android.synthetic.main.items.view.*

class EmpAdapter(var context: MainActivity, var mEmpList: ArrayList<Android>, private val itemClick:ItemClickListener): RecyclerView.Adapter<EmpAdapter.EmpHolder>()  {

    companion object {
         var mItemClickListener : ItemClickListener? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.items, parent, false)
        return EmpHolder(view)
    }

    override fun getItemCount(): Int {
        return mEmpList.size
    }

    override fun onBindViewHolder(holder:EmpHolder, position: Int) {
        mItemClickListener = itemClick
        holder.tvFname?.text = mEmpList[position].name
        holder.tvLname?.text = mEmpList[position].apiLevel

        RxView.clicks(holder.mView).subscribe {
            mItemClickListener!!.onItemClick(position)
        }
    }


    class EmpHolder (view: View) : RecyclerView.ViewHolder(view) {
        val tvFname = view.tvFname
        val tvLname = view.tvLname
        val mView = view
    }

}