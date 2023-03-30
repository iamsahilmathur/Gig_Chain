package com.gigchain.soft.presentation.utilities

import androidx.fragment.app.Fragment

/*
* We have added autoCleaned extension function to fragment class
* */
fun <T : Any> Fragment.autoCleaned(initializer: (() -> T)? = null): AutoCleanedValue<T> {
    return AutoCleanedValue(this, initializer)
}