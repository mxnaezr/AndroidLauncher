package com.example.launcher.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.launcher.adapters.AppGridAdapter
import com.example.launcher.databinding.ActivityLauncherBinding
import com.example.launcher.services.AppListService

class LauncherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLauncherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLauncherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apps = AppListService(this).getInstalledApps()

        binding.appGrid.layoutManager = GridLayoutManager(this, 4)
        binding.appGrid.adapter = AppGridAdapter(apps) { app ->
            val launchIntent = packageManager.getLaunchIntentForPackage(app.packageName)
            launchIntent?.let { startActivity(it) }
        }
    }

    override fun onResume() {
        super.onResume()
        // Refresh logic will be connected to the ViewModel in the persistence phase.
    }
}
