package com.farida.lifehackstudiotest.ui.company

import com.farida.lifehackstudiotest.model.Company
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface CompanyView : MvpView {

    fun setCompany(company: Company)
    fun setErrorMessage(textResource: Int)
}