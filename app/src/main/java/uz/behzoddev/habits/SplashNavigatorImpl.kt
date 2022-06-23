package uz.behzoddev.habits

import android.app.Activity
import uz.behzoddev.common_ui.extensions.startAndFinish
import uz.behzoddev.feature_onboarding.OnboardingActivity
import uz.behzoddev.feature_splash.SplashNavigator
import javax.inject.Inject

class SplashNavigatorImpl @Inject constructor(
    private val activity: Activity
) : SplashNavigator {

    override fun navigateToMain() {
        activity.startAndFinish<OnboardingActivity>()
    }
}