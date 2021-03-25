package com.farida.lifehackstudiotest.remote

import com.farida.lifehackstudiotest.model.Company
import io.reactivex.Single
import javax.inject.Inject

class LifehackStudioDataSource @Inject constructor(private val lifehackStudioService: LifehackStudioService) {

    fun getCompanies(): Single<List<Company>> = lifehackStudioService.getCompanies()

    fun getCompanyById(id: Long): Single<List<Company>> = lifehackStudioService.getCompanyById(id)
}
