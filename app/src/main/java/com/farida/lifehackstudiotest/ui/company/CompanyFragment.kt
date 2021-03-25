package com.farida.lifehackstudiotest.ui.company

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.bumptech.glide.Glide
import com.farida.lifehackstudiotest.MyApplication
import com.farida.lifehackstudiotest.R
import com.farida.lifehackstudiotest.databinding.FragmentCompanyBinding
import com.farida.lifehackstudiotest.model.Company
import com.farida.lifehackstudiotest.remote.Constants
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider

class CompanyFragment : MvpAppCompatFragment(), CompanyView {

    private var id: Long = 0

    private var fragmentCompanyBinding: FragmentCompanyBinding? = null
    private val binding get() = fragmentCompanyBinding!!

    @Inject
    lateinit var companyProvider: Provider<CompanyPresenter>

    @InjectPresenter
    lateinit var companyPresenter: CompanyPresenter

    @ProvidePresenter
    fun providePresenter(): CompanyPresenter {
        return companyProvider.get()
    }

    override fun onAttach(context: Context) {
        (activity?.applicationContext as MyApplication).applicationComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        fragmentCompanyBinding = FragmentCompanyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        id = requireArguments().getLong(ARG_COMPANY_KEY)
        companyPresenter.loadCompanyById(id)
        binding.retryBtn.setOnClickListener {
            companyPresenter.loadCompanyById(id)
        }
    }

    override fun setCompany(company: Company) {
        with(binding) {
            error.visibility = View.GONE
            retryBtn.visibility = View.GONE
            group.visibility = View.VISIBLE
            name.text = company.name
            description.text = company.description?.trim()
            phone.text = if (company.phone.isNullOrBlank()) {
                getString(R.string.phone, getString(R.string.emptyValue))
            } else {
                getString(R.string.phone, company.phone)
            }
            title.text = getString(R.string.coord)
            lon.text = if (company.lon.isNullOrBlank() || company.lon == "0") {
                getString(R.string.lon, getString(R.string.emptyValue))
            } else {
                getString(R.string.lon, company.lon)
            }
            lat.text = if (company.lat.isNullOrBlank() || company.lat == "0") {
                getString(R.string.lat, getString(R.string.emptyValue))
            } else {
                getString(R.string.lat, company.lat)
            }
            www.text = if (company.www.isNullOrBlank()) {
                getString(R.string.www, getString(R.string.emptyValue))
            } else {
                getString(R.string.www, company.www)
            }
            Glide.with(this@CompanyFragment)
                    .load(Constants.BASE_URL_VALUE + company.image)
                    .error(R.drawable.nophoto)
                    .into(image)
        }
    }

    override fun setErrorMessage(textResource: Int) {
        with(binding) {
            group.visibility = View.GONE
            error.visibility = View.VISIBLE
            error.text = getString(textResource)
            retryBtn.visibility = View.VISIBLE
        }
    }

    companion object {
        private const val ARG_COMPANY_KEY = "company_key"
        fun newInstance(id: Long): CompanyFragment = CompanyFragment().apply {
            arguments = bundleOf(ARG_COMPANY_KEY to id)
        }
    }
}