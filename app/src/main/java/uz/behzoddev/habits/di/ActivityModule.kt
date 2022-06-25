package uz.behzoddev.habits.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import uz.behzoddev.feature_onboarding.OnboardingNavigator
import uz.behzoddev.feature_splash.SplashNavigator
import uz.behzoddev.habits.OnboardingNavigatorImpl
import uz.behzoddev.habits.SplashNavigatorImpl

@Module
@InstallIn(ActivityComponent::class)
interface ActivityModule {

    @Binds
    fun providesSplashNavigator(
        navigator: SplashNavigatorImpl
    ): SplashNavigator

    @Binds
    fun providesOnboardingNavigator(
        navigator: OnboardingNavigatorImpl
    ): OnboardingNavigator
}