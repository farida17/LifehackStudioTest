package com.farida.lifehackstudiotest.repository

import com.farida.lifehackstudiotest.model.Company
import com.farida.lifehackstudiotest.remote.LifehackStudioDataSource
import io.reactivex.Single
import javax.inject.Inject

class LifehackStudioRepositoryImpl @Inject constructor(private val lifehackStudioDataSource: LifehackStudioDataSource): LifehackStudioRepository {

    override fun getCompanies(): Single<List<Company>> {
        return lifehackStudioDataSource.getCompanies()
    }

    override fun getCompanyById(id: Long): Single<List<Company>> {
        return lifehackStudioDataSource.getCompanyById(id)
    }
}