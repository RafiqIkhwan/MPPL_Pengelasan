package com.example.rpl_pengelasan.data_model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView
import com.example.rpl_pengelasan.R


class AdapterListAnggota(private val dataSet: ArrayList<*>, mContext: Context) :
    ArrayAdapter<Any?>(mContext, R.layout.raw_item, dataSet) {
    private class ViewHolder {
        lateinit var txtName: TextView
        lateinit var checkBox: CheckBox
    }

    override fun getCount(): Int {
        return dataSet.size
    }

    override fun getItem(position: Int): ModelListAnggota {
        return dataSet[position] as ModelListAnggota
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var convertView = convertView
        val viewHolder: ViewHolder
        val result: View
        if (convertView == null) {
            viewHolder = ViewHolder()
            convertView =
                LayoutInflater.from(parent.context).inflate(R.layout.raw_item, parent, false)
            viewHolder.txtName =
                convertView.findViewById(R.id.txtName)
            viewHolder.checkBox =
                convertView.findViewById(R.id.checkBox)
            result = convertView
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as ViewHolder
            result = convertView
        }

        val item: ModelListAnggota = getItem(position)
        viewHolder.txtName.text = item.name
        viewHolder.checkBox.isChecked = item.checked
        return result
    }
}