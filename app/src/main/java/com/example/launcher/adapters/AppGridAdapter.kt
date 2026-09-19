package com.example.launcher.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.launcher.databinding.ItemAppBinding
import com.example.launcher.models.AppInfo

class AppGridAdapter(
    private var apps: List<AppInfo>,
    private val onClick: (AppInfo) -> Unit
) : RecyclerView.Adapter<AppGridAdapter.AppViewHolder>() {

    inner class AppViewHolder(
        private val binding: ItemAppBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(app: AppInfo) {
            binding.appIcon.setImageDrawable(app.icon)
            binding.appName.text = app.label
            binding.root.setOnClickListener { onClick(app) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AppViewHolder(
            ItemAppBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) =
        holder.bind(apps[position])

    override fun getItemCount() = apps.size

    fun submitList(newApps: List<AppInfo>) {
        apps = newApps
        notifyDataSetChanged()
    }
}
