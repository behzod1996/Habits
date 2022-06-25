package uz.behzoddev.feature_onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor() : ViewModel() {

    private var _viewEffect = MutableSharedFlow<OnboardingViewEffect>()

    val viewEffect: SharedFlow<OnboardingViewEffect> get() = _viewEffect
    val lists : MutableList<OnboardingItem> = ArrayList()

    init {
        val items = listOf(
            OnboardingItem(
                title = "WELCOME TO \n Monumental habits",
                description = "We can help you to be a better version of yourself.",
                image = R.drawable.ic_onboarding_welcome
            ),
            OnboardingItem(
                title = "CREATE NEW \n HABIT EASILY",
                description = "We can help you to be a better version of yourself.",
                image = R.drawable.ic_onboarding_habit
            ),
            OnboardingItem(
                title = "KEEP TRACK OF YOUR \n PROGRESS",
                description = "We can help you to be a better version of yourself.",
                image = R.drawable.ic_onboarding_progress
            ),
            OnboardingItem(
                title = "JOIN A SUPPORTIVE \n COMMUNITY",
                description = "We can help you to be a better version of yourself.",
                image = R.drawable.ic_onboarding_community_support
            )
        )

        lists.addAll(
            items
        )

    }
    fun onEvent(event: OnboardingEvent) {
        when (event) {
            OnboardingEvent.GetStartedEvent -> {
                setOnboardingViewEffects(OnboardingViewEffect.GetStartedViewEffect)
            }
            OnboardingEvent.NextEvent -> {
                setOnboardingViewEffects(OnboardingViewEffect.NextViewEffect)

            }
            OnboardingEvent.SkipEvent -> {
                setOnboardingViewEffects(OnboardingViewEffect.SkipViewEffect)
            }
        }
    }

    private fun setOnboardingViewEffects(effect: OnboardingViewEffect) {
        viewModelScope.launch {
            when (effect) {
                OnboardingViewEffect.GetStartedViewEffect -> {
                    _viewEffect.emit(OnboardingViewEffect.GetStartedViewEffect)
                }
                OnboardingViewEffect.NextViewEffect -> {
                    _viewEffect.emit(OnboardingViewEffect.NextViewEffect)
                }
                OnboardingViewEffect.SkipViewEffect -> {
                    _viewEffect.emit(OnboardingViewEffect.SkipViewEffect)
                }
            }
        }

    }


}