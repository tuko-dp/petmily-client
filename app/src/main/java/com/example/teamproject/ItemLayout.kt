package com.example.teamproject

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.jar.Attributes

class ItemLayout: BaseAdapter() {
    private var listViewItemList = ArrayList<ListViewItem>()

    override fun getCount(): Int {
        return listViewItemList.size
    }

    override fun getItem(position: Int): Any {
        return listViewItemList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        val context = parent?.context

        if(view == null) {
            val inflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.activity_item_layout, parent, false)
        }

        val facilitiesView = view!!.findViewById(R.id.facilities) as TextView
        val categoryView = view!!.findViewById(R.id.category) as TextView
        val locationView = view!!.findViewById(R.id.location) as TextView
        val operateView = view!!.findViewById(R.id.operate) as TextView
        val callView = view!!.findViewById(R.id.call) as TextView
        val previewImg = view!!.findViewById(R.id.preview) as ImageView

        val listViewItem = listViewItemList[position]
        facilitiesView.setText(listViewItem.facilities)
        categoryView.setText(listViewItem.category)
        locationView.setText(listViewItem.location)
        operateView.setText(listViewItem.operate)
        callView.setText(listViewItem.call)
        previewImg.setImageDrawable(listViewItem.preview)

        return view
    }

    fun addFacilities(facilities: String) {
        val item = ListViewItem()
        item.facilities = facilities

        listViewItemList.add(item)
    }

    fun addItem(facilities: String, category: String, location: String, operate: String, call: String, preview: Drawable) {
        val item = ListViewItem()
        item.facilities = facilities
        item.category = category
        item.location = location
        item.operate = operate
        item.call = call
        item.preview = preview

        listViewItemList.add(item)
    }

}