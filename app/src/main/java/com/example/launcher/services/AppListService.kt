package com.example.launcher.services

import android.content.Context
import android.content.Intent
import com.example.launcher.models.AppInfo

class AppListService(private val context: Context) {

    fun getInstalledApps(): List<AppInfo> {
        val packageManager = context.packageManager
        val intent = Intent(Intent.ACTION_MAIN).apply {
            addCategory(Intent.CATEGORY_LAUNCHER)
        }

        return packageManager.queryIntentActivities(intent, 0)
            .map {
                AppInfo(
                    packageName = it.activityInfo.packageName,
                    label = it.loadLabel(packageManager).toString(),
                    icon = it.loadIcon(packageManager)
                )
            }
            .distinctBy { it.packageName }
            .sortedBy { it.label.lowercase() }
    }
}
