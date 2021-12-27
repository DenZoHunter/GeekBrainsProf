package com.example.applicationarchitecturegeekbrains.data.datasource.user

import com.example.applicationarchitecturegeekbrains.data.GitHubUser
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single

interface GitHubUserDataSource {

    fun getUsers(): Single<List<GitHubUser>>

    fun getUserByLogin(userId: String): Maybe<GitHubUser>

}
