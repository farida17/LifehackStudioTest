package com.farida.lifehackstudiotest.ui.companieslist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.farida.lifehackstudiotest.MyApplication
import com.farida.lifehackstudiotest.databinding.FragmentListBinding
import com.farida.lifehackstudiotest.model.Company
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider

class CompaniesListFragment : MvpAppCompatFragment(), CompaniesListView,
    CompaniesListAdapter.OnCompanyClickListener {

    @Inject
    lateinit var companiesListProvider: Provider<CompaniesListPresenter>

    @InjectPresenter
    lateinit var companiesListPresenter: CompaniesListPresenter

    @ProvidePresenter
    fun providePresenter(): CompaniesListPresenter {
        return companiesListProvider.get()
    }

    private var onOpenCompanyClickListener: OnOpenCompanyClickListener? = null
    private var fragmentListBinding: FragmentListBinding? = null
    private val binding get() = fragmentListBinding!!

    private val companiesListAdapter = CompaniesListAdapter(this)

    override fun onAttach(context: Context) {
        (activity?.applicationContext as MyApplication).applicationComponent.inject(this)
        super.onAttach(context)
        if (context is OnOpenCompanyClickListener) {
            onOpenCompanyClickListener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentListBinding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerview()
    }

    private fun initRecyclerview() {
        binding.listRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = companiesListAdapter
        }
    }

    override fun setCompaniesList(companies: List<Company>) {
        companiesListAdapter.submitList(companies)
    }

    override fun setErrorMessage(textResource: Int) {
        Toast.makeText(requireContext(), textResource, Toast.LENGTH_SHORT).show()
    }

    override fun onCompanyClick(adapterPosition: Int) {
        onOpenCompanyClickListener?.onOpenCompany(companiesListAdapter.currentList[adapterPosition].id)
    }
}