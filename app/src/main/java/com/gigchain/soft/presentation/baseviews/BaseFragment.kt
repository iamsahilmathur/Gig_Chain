package com.gigchain.soft.presentation.baseviews

import android.graphics.Point
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModel
import com.gigchain.soft.R
import com.gigchain.soft.presentation.utilities.DrawMarker
import com.gigchain.soft.presentation.utilities.MyInfoWindowAdapter
import com.gigchain.soft.presentation.utilities.autoCleaned
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.PolylineOptions


abstract class BaseFragment<V : ViewDataBinding, VM : ViewModel> : Fragment(), OnMapReadyCallback {
    private var mBinding: V by autoCleaned()
    private var googleMap: GoogleMap? = null
    private var mapFragment: SupportMapFragment? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<V>(layoutInflater, getLayoutId(), container, false).also {
        it.setVariable(getBindingVariable(), getViewModel())
        mBinding = it
    }.root

    fun getBinding(): V {
        return mBinding
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): VM

    abstract fun getBindingVariable(): Int

    open fun replaceFragment(someFragment: Fragment?, id: Int) {
        val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
        transaction.setCustomAnimations(R.anim.anim_in_test, R.anim.anim_out_test)
        if (someFragment != null) {
            transaction.add(id, someFragment)
        }
        transaction.addToBackStack(someFragment?.javaClass?.name)
        transaction.commit()
    }

    fun getMap(): GoogleMap? {
        return googleMap
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        this.googleMap = googleMap
        googleMap?.setMapStyle(
            MapStyleOptions.loadRawResourceStyle(
                requireContext(), R.raw.style_json
            )
        )
        val lineOptions = PolylineOptions()
        val points = ArrayList<LatLng?>()
        val origin = LatLng(-7.788969, 110.338382)
        val destination = LatLng(-7.781200, 110.349709)
        points.add(origin)
        points.add(destination)
        lineOptions.addAll(points)
        lineOptions.width(12f)
        lineOptions.color(ContextCompat.getColor(requireActivity(), R.color.mapLineColor))
        googleMap?.addPolyline(lineOptions)
        DrawMarker.getInstance(requireActivity())
            ?.draw(googleMap!!, origin, R.drawable.ic_destination, "You")
        DrawMarker.getInstance(requireActivity())
            ?.draw(googleMap!!, destination, R.drawable.ic_destination, "Destination")
        val bounds = LatLngBounds.Builder().include(origin).include(destination).build()
        val displaySize = Point()
        @Suppress("DEPRECATION") requireActivity()?.windowManager?.defaultDisplay?.getSize(
            displaySize
        )
        googleMap?.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, displaySize.x, 250, 30))
        googleMap?.setInfoWindowAdapter(MyInfoWindowAdapter(requireActivity()))

    }


    fun setMapView(containerId: Int) {
        try {
            mapFragment = SupportMapFragment.newInstance()
            val fragmentTransaction = childFragmentManager.beginTransaction()
            fragmentTransaction.replace(containerId, mapFragment!!)
            fragmentTransaction.commitAllowingStateLoss()
            mapFragment?.getMapAsync(this)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}