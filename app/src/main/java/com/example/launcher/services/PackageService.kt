package com.example.launcher.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class PackageService : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        when (intent.action) {
            Intent.ACTION_PACKAGE_ADDED,
            Intent.ACTION_PACKAGE_REMOVED -> {
                // Notify/refresh the launcher app list.
                // Database synchronization is implemented in the discovery phase.
            }
        }
    }
}
