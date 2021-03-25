package com.farida.lifehackstudiotest.ui.companieslist

import com.farida.lifehackstudiotest.R
import com.farida.lifehackstudiotest.repository.LifehackStudioRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class CompaniesListPresenter(var lifehackStudioRepository: LifehackStudioRepository) :
    MvpPresenter<CompaniesListView>() {

    private val subscriptions = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadCompanies()
    }

    private fun loadCompanies() {
        val subscribe = lifehackStudioRepository.getCompanies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(onSuccess = {
                viewState.setCompaniesList(it)
            }, onError = {
                viewState.setErrorMessage(R.string.error_message)
            })
        subscriptions.add(subscribe)
    }

    override fun onDestroy() {
        super.onDestroy()
        subscriptions.dispose()
    }
}