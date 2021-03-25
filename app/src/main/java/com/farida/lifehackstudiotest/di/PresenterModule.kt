package com.farida.lifehackstudiotest.di

import com.farida.lifehackstudiotest.repository.LifehackStudioRepository
import com.farida.lifehackstudiotest.ui.companieslist.CompaniesListPresenter
import com.farida.lifehackstudiotest.ui.company.CompanyPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun provideCompaniesListPresenter(lifehackStudioRepository: LifehackStudioRepository): CompaniesListPresenter {
        return CompaniesListPresenter(lifehackStudioRepository)
    }

    @Provides
    fun provideCompanyPresenter(lifehackStudioRepository: LifehackStudioRepository): CompanyPresenter {
        return CompanyPresenter(lifehackStudioRepository)
    }
}