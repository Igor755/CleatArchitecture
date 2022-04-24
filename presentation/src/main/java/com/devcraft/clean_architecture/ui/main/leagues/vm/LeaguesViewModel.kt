package com.devcraft.clean_architecture.ui.main.leagues.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devcraft.clean_architecture.extension.mapto
import com.devcraft.clean_architecture.model.Leagues
import com.devcraft.domain.interactor.LeaguesInteractor
import com.devcraft.domain.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LeaguesViewModel(private val leaguesInteractor: LeaguesInteractor) : ViewModel() {

    var leaguesLiveData: MutableLiveData<Result<Leagues>>
    private var _leaguesLiveData = MutableLiveData<Result<Leagues>>()

    init {
        leaguesLiveData = _leaguesLiveData
    }

    fun getLeaguesFromServer() {
        viewModelScope.launch(Dispatchers.IO) {
            leaguesInteractor.getLeagues({
                _leaguesLiveData.postValue(Result.Success(it?.mapto()))
            }, {
                _leaguesLiveData.postValue(Result.Error(it))
            })
        }
    }
}