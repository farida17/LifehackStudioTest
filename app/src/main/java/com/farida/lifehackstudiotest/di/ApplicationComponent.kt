package com.farida.lifehackstudiotest.di

import com.farida.lifehackstudiotest.ui.companieslist.CompaniesListFragment
import com.farida.lifehackstudiotest.ui.company.CompanyFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, LifehackStudioServiceModule::class, PresenterModule::class, RepositoryModule::class])
interface ApplicationComponent {

    fun inject(companiesListFragment: CompaniesListFragment)

    fun inject(companyFragment: CompanyFragment)
}