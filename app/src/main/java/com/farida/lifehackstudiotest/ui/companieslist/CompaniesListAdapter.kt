package com.farida.lifehackstudiotest.ui.companieslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.farida.lifehackstudiotest.R
import com.farida.lifehackstudiotest.databinding.ListCompaniesBinding
import com.farida.lifehackstudiotest.model.Company
import com.farida.lifehackstudiotest.remote.Constants

class CompaniesListAdapter(private val onCompanyClickListener: OnCompanyClickListener) :
    ListAdapter<Company, CompaniesListAdapter.ViewHolder>(DIFF_CALLBACK) {

    interface OnCompanyClickListener {
        fun onCompanyClick(adapterPosition: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ListCompaniesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding, onCompanyClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val itemBinding: ListCompaniesBinding,
        private val listener: OnCompanyClickListener
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        init {
            itemView.setOnClickListener { listener.onCompanyClick(adapterPosition) }
        }

        fun bind(company: Company) {
            with(company) {
                itemBinding.companyName.text = name
                Glide.with(itemView.context)
                    .load(Constants.BASE_URL_VALUE + image)
                    .error(R.drawable.nophoto)
                    .into(itemBinding.companyImage)
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Company>() {
            override fun areItemsTheSame(
                oldItem: Company,
                newItem: Company
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: Company,
                newItem: Company
            ): Boolean = oldItem == newItem
        }
    }
}