package com.gigchain.soft.presentation.utilities

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class DrawMarker internal constructor(private val context: Context) {

    // draw marker on maps
    fun draw(googleMap: GoogleMap, location: LatLng?, resDrawable: Int, title: String?) {
        val circleDrawable = ContextCompat.getDrawable(
            context, resDrawable
        )
        val markerIcon = getMarkerIconFromDrawable(circleDrawable)
        googleMap.addMarker(
            MarkerOptions()
                .position(location!!)
                .title(title)
                .icon(markerIcon)
        )

    }

    private fun getMarkerIconFromDrawable(drawable: Drawable?): BitmapDescriptor {
        val canvas = Canvas()
        val bitmap = Bitmap.createBitmap(
            drawable!!.intrinsicWidth,
            drawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888
        )
        canvas.setBitmap(bitmap)
        drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
        drawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }

    // creating singleton
    companion object {
        var INSTANCE: DrawMarker? = null
        fun getInstance(context: Context): DrawMarker? {
            if(INSTANCE == null)
            INSTANCE = DrawMarker(context)

            return INSTANCE
        }
    }
}