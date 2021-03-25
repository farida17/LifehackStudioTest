package com.farida.lifehackstudiotest.ui.company

import com.farida.lifehackstudiotest.R
import com.farida.lifehackstudiotest.repository.LifehackStudioRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class CompanyPresenter @Inject constructor(private val lifehackStudioRepository: LifehackStudioRepository) :
    MvpPresenter<CompanyView>() {

    private val subscriptions = CompositeDisposable()

    fun loadCompanyById(id: Long) {
        val subscribe = lifehackStudioRepository.getCompanyById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(onSuccess = {
                viewState.setCompany(it[0])
            }, onError = {
                viewState.setErrorMessage(R.string.error)
            })
        subscriptions.add(subscribe)
    }

    override fun onDestroy() {
        super.onDestroy()
        subscriptions.dispose()
    }
}