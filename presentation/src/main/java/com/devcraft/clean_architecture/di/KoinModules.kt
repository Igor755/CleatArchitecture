package com.devcraft.clean_architecture.di

import com.devcraft.clean_architecture.ui.main.leagues.adapter.LeaguesAdapter
import com.devcraft.clean_architecture.ui.main.leagues.vm.LeaguesViewModel
import com.devcraft.clean_architecture.ui.main.season.adapter.SeasonAdapter
import com.devcraft.clean_architecture.ui.main.season.vm.SeasonViewModel
import com.devcraft.clean_architecture.ui.screen_name.viewmodel.GenericViewModel
import com.devcraft.domain.interactor.GenericInteractor
import com.devcraft.domain.interactor.LeaguesInteractor
import com.devcraft.domain.interactor.SeasonInteractor
import org.koin.dsl.module

val adaptersModule = module {
    factory { LeaguesAdapter() }
    factory { SeasonAdapter() }

}

val viewModelsModule = module {
    factory { GenericViewModel(get()) }
    factory { LeaguesViewModel(get()) }
    factory { SeasonViewModel(get()) }
}

val interactorsModule = module {
    factory { GenericInteractor() }
    factory { LeaguesInteractor() }
    factory { SeasonInteractor() }
}

