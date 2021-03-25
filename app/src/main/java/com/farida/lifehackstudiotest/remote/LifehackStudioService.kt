package com.farida.lifehackstudiotest.remote

import com.farida.lifehackstudiotest.model.Company
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface LifehackStudioService {

    @GET("test.php")
    fun getCompanies(): Single<List<Company>>

    @GET("test.php?id=id")
    fun getCompanyById(@Query("id") id: Long): Single<List<Company>>
}