package com.farida.lifehackstudiotest.ui.main

import android.os.Bundle
import com.farida.lifehackstudiotest.R
import com.farida.lifehackstudiotest.ui.companieslist.CompaniesListFragment
import com.farida.lifehackstudiotest.ui.companieslist.OnOpenCompanyClickListener
import com.farida.lifehackstudiotest.ui.company.CompanyFragment
import moxy.MvpAppCompatActivity

class MainActivity : MvpAppCompatActivity(), OnOpenCompanyClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.mainFragmentContainer, CompaniesListFragment())
                    .commit()
        }
    }

    override fun onOpenCompany(id: Long) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainFragmentContainer, CompanyFragment.newInstance(id))
            .addToBackStack(null)
            .commit()
    }
}