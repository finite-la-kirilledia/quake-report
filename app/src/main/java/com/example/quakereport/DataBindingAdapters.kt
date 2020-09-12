package com.example.quakereport

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter

@BindingAdapter("loadingStatus")
fun bindProgressBar(progressBar: ProgressBar, loadingStatus: LoadingStatus?) {
    when (loadingStatus) {
        LoadingStatus.LOADING -> progressBar.visibility = View.VISIBLE
        LoadingStatus.ERROR -> progressBar.visibility = View.GONE
        LoadingStatus.DONE -> progressBar.visibility = View.GONE
    }
}