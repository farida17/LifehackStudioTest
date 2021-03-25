package com.farida.lifehackstudiotest.repository

import com.farida.lifehackstudiotest.model.Company
import io.reactivex.Single

interface LifehackStudioRepository {

    fun getCompanies(): Single<List<Company>>

    fun getCompanyById(id: Long): Single<List<Company>>
}