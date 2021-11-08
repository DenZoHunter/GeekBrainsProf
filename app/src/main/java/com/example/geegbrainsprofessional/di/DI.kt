package com.example.geegbrainsprofessional.di

import com.example.geegbrainsprofessional.domain.repository.StopwatchRepository
import com.example.geegbrainsprofessional.domain.repository.StopwatchRepositoryImpl
import com.example.geegbrainsprofessional.presentation.dictionary.StopwatchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object DI {

    fun getModule() = module {

        single<StopwatchRepository> { StopwatchRepositoryImpl() }

        viewModel { StopwatchViewModel(stopwatchRepository = get()) }

    }

}