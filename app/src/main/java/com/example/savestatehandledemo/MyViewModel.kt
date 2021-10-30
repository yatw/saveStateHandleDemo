package com.example.savestatehandledemo


import android.app.Activity
import android.app.Application
import androidx.lifecycle.*
import androidx.savedstate.SavedStateRegistryOwner

class MyViewModel(application: Application,
                  savedStateHandle: SavedStateHandle,
                  val someString: String) : AndroidViewModel(application){

    class Factory(val activity: Activity, val someString: String):
        AbstractSavedStateViewModelFactory(activity as SavedStateRegistryOwner, null) {

        override fun <T : ViewModel?> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T {
            if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MyViewModel(activity.application, handle, someString) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }

    fun doubleTheInput(): String{
        return someString + someString
    }
}