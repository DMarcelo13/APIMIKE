package com.example.apimike.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import com.example.apimike.intent.Intent
import com.example.apimike.repository.FoxRepository
import com.example.apimike.utils.DataState
import javax.inject.Inject

@ExperimentalCoroutinesApi
class MainViewModel
@ViewModelInject
constructor(
    private val foxRepository: FoxRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    val userIntent = Channel<Intent>(Channel.UNLIMITED)

    private val _dataState= MutableStateFlow<DataState>(DataState.Idle)

    val dataState: StateFlow<DataState>
        get() = _dataState
    init {
        setStateEvent()
    }
    fun setStateEvent() {
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect { intnt ->
                when (intnt) {
                    is Intent.GetFoxEvent -> {
                        foxRepository.getFoxs()
                            .onEach {
                                _dataState.value = it
                            }
                            .launchIn(viewModelScope)
                    }
                    Intent.None -> {
                    }
                }

            }
        }
    }
}