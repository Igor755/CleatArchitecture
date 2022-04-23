package com.devcraft.clean_architecture.common.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.devcraft.clean_architecture.extension.isNetworkConnected
import java.lang.RuntimeException

class InternetConnectionBroadcastReceiver(private val onConnectionUpdate: ((Boolean) -> Unit)? =null) :
    BroadcastReceiver() {
    override fun onReceive(ctx: Context?, p1: Intent?) {
        try {
            onConnectionUpdate?.invoke(ctx?.isNetworkConnected() ?: false)
        } catch (e : RuntimeException) {}
    }

}