package uz.behzoddev.feature_splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val WAITING_TIME = 3000L

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    private var _viewEffect = MutableSharedFlow<SplashViewEffects>()

    val viewEffects: SharedFlow<SplashViewEffects> get() = _viewEffect

    fun onEvent(event: SplashEvent) {
        when(event) {
            SplashEvent.MainEvent -> navigateToMain()
        }
    }
    private fun navigateToMain() {
        viewModelScope.launch {
            delay(WAITING_TIME)
            _viewEffect.emit(SplashViewEffects.MainViewEffects)
        }
    }
}