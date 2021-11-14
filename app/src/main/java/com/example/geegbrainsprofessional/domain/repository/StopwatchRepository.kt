package com.example.geegbrainsprofessional.domain.repository

import kotlinx.coroutines.flow.StateFlow

interface StopwatchRepository {
    suspend fun updateTicker(delay: Long)
    suspend fun getTicker(): StateFlow<Long>
    suspend fun clearTicker()
}