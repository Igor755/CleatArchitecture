package com.devcraft.clean_architecture.ui.main.season.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devcraft.clean_architecture.extension.map
import com.devcraft.clean_architecture.model.Season
import com.devcraft.domain.interactor.SeasonInteractor
import com.devcraft.domain.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SeasonViewModel(private val seasonInteractor: SeasonInteractor) : ViewModel(){

    var seasonLiveData: MutableLiveData<Result<Season>>
    private var _seasonLiveData = MutableLiveData<Result<Season>>()

    init {
        seasonLiveData = _seasonLiveData
    }

    fun getSeasonFromServer(id : String) {
        viewModelScope.launch(Dispatchers.IO) {
            seasonInteractor.getSeason(id,{
                _seasonLiveData.postValue(Result.Success(it?.map()))
            }, {
                _seasonLiveData.postValue(Result.Error(it))
            })
        }
    }
}