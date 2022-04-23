package com.devcraft.clean_architecture.di

import com.devcraft.clean_architecture.ui.main.leagues.adapter.LeaguesAdapter
import com.devcraft.clean_architecture.ui.main.leagues.vm.LeaguesViewModel
import com.devcraft.clean_architecture.ui.screen_name.viewmodel.GenericViewModel
import com.devcraft.domain.interactor.GenericInteractor
import com.devcraft.domain.interactor.LeaguesInteractor
import org.koin.dsl.module

val adaptersModule = module {
    factory { LeaguesAdapter() }
}

val viewModelsModule = module {
    factory { GenericViewModel(get()) }
    factory { LeaguesViewModel(get()) }
}

val interactorsModule = module {
    factory { GenericInteractor() }
    factory { LeaguesInteractor() }

}

