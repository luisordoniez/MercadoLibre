package com.meli.shop.features

import android.app.AlertDialog
import android.os.Bundle
import android.widget.TextView
import com.meli.shop.R
import dagger.android.support.DaggerFragment

/**
 * Created by Luis Ordoñez on 11/09/2021.
 */

open class BaseFragment: DaggerFragment(){
    lateinit var dialog: AlertDialog
    lateinit var textView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val builder = AlertDialog.Builder(requireActivity())
        val dialogView = layoutInflater.inflate(R.layout.custom_progressdialog, null)
        textView = dialogView.findViewById(R.id.message)

        builder.setView(dialogView)
        builder.setCancelable(false)
        dialog = builder.create()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

    }

    fun showProgressBar(show: Boolean,message : String? = ""){
        textView.text = message
        if (show)dialog.show() else dialog.dismiss()
    }

}