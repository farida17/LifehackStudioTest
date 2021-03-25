package com.farida.lifehackstudiotest.di

import com.farida.lifehackstudiotest.remote.LifehackStudioDataSource
import com.farida.lifehackstudiotest.repository.LifehackStudioRepository
import com.farida.lifehackstudiotest.repository.LifehackStudioRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun bindsLifehackStudioRepository(lifehackStudioDataSource: LifehackStudioDataSource): LifehackStudioRepository {
        return LifehackStudioRepositoryImpl(lifehackStudioDataSource)
    }
}