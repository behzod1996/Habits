package uz.behzoddev.feature_onboarding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import uz.behzoddev.feature_onboarding.databinding.ActivityOnboardingBinding

@AndroidEntryPoint
class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding
    private lateinit var viewPager: OnboardingViewPagerAdapter

    private val listScreen: MutableList<OnboardingItem> = ArrayList<OnboardingItem>()
    private var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {

        val lists = listOf(
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
        listScreen.addAll(lists)

        viewPager = OnboardingViewPagerAdapter(this,listScreen)
        binding.viewPager.adapter = viewPager

        binding.tabIndicator.setupWithViewPager(binding.viewPager)

        binding.tabIndicator.addOnTabSelectedListener(object :
            TabLayout.BaseOnTabSelectedListener<TabLayout.Tab?> {
            override fun onTabSelected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}