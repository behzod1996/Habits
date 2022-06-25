package uz.behzoddev.habits

import android.app.Activity
import uz.behzoddev.common_ui.extensions.startAndFinish
import uz.behzoddev.feature_onboarding.OnboardingNavigator
import javax.inject.Inject

class OnboardingNavigatorImpl @Inject constructor(
    private val activity: Activity
) : OnboardingNavigator {

    override fun navigateToHome() {
        activity.startAndFinish<MainActivity>()
    }
}