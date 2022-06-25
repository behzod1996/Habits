package uz.behzoddev.habits.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import uz.behzoddev.feature_onboarding.OnboardingNavigator
import uz.behzoddev.habits.OnboardingNavigatorImpl

@Module
@InstallIn(FragmentComponent::class)
interface FragmentModule {

}