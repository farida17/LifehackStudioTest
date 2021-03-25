package com.farida.lifehackstudiotest.di

import android.app.Application
import android.content.Context
import com.farida.lifehackstudiotest.remote.LifehackStudioDataSource
import com.farida.lifehackstudiotest.remote.LifehackStudioService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideAppContext(): Context = application

    @Provides
    @Singleton
    fun providesLifehackStudioDataSource(lifehackStudioService: LifehackStudioService): LifehackStudioDataSource {
        return LifehackStudioDataSource(lifehackStudioService)
    }
}