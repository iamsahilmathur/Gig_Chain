package com.gigchain.soft.presentation.utilities

import android.view.View


/*
*  Extension function in View class with delay to avoid instant double tap
* */
fun View.setSafeOnClickListener(onSafeClick: (View) -> Unit) {
    val safeClickListener = SafeClickListener {
        onSafeClick(it)
    }
    setOnClickListener(safeClickListener)
}

