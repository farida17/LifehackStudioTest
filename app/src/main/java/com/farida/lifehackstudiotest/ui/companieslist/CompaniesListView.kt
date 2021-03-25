package com.farida.lifehackstudiotest.ui.companieslist

import com.farida.lifehackstudiotest.model.Company
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface CompaniesListView : MvpView {
    fun setCompaniesList(companies: List<Company>)
    fun setErrorMessage(textResource: Int)
}