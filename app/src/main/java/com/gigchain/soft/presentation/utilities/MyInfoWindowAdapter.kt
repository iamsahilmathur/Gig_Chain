package com.gigchain.soft.presentation.utilities

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.gigchain.soft.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
/*
*
*  Modify marker icons on maps
* */
class MyInfoWindowAdapter(mContext: Context) : GoogleMap.InfoWindowAdapter {
    var mWindow: View = LayoutInflater.from(mContext).inflate(R.layout.layout_marker, null)


    private fun setInfoWindowText(marker: Marker) {
        val title = marker.title
        val tvTitle = mWindow.findViewById<TextView>(R.id.tvTitle)
        if (!TextUtils.isEmpty(title)) {
            tvTitle.text = title
        }
    }

    override fun getInfoWindow(p0: Marker): View {
        setInfoWindowText(p0)
        return mWindow
    }

    override fun getInfoContents(p0: Marker): View {
        setInfoWindowText(p0)
        return mWindow
    }
}