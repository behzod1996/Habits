package uz.behzoddev.feature_onboarding

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import uz.behzoddev.common_ui.extensions.hide
import uz.behzoddev.common_ui.extensions.show
import uz.behzoddev.feature_onboarding.databinding.ActivityOnboardingBinding
import javax.inject.Inject

@AndroidEntryPoint
class OnboardingActivity : AppCompatActivity() {

    @Inject
    lateinit var navigator: OnboardingNavigator

    private lateinit var binding: ActivityOnboardingBinding
    private lateinit var mViewPager: OnboardingViewPagerAdapter
    private val viewModel: OnboardingViewModel by viewModels()

    private var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)

        setFullContent()

        supportActionBar?.hide()

        setContentView(binding.root)

        setupUI()

        observerEvents()
    }

    private fun setFullContent() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }

    private fun setupUI() {

        mViewPager = OnboardingViewPagerAdapter(this, viewModel.lists)

        binding.apply {
            viewPager.adapter = mViewPager
            dotsIndicator.attachTo(viewPager)
        }


        binding.tvNext.setOnClickListener {
            viewModel.onEvent(OnboardingEvent.NextEvent)
        }

        binding.tvSkip.setOnClickListener {
           viewModel.onEvent(OnboardingEvent.SkipEvent)
        }

        binding.btnGetStarted.setOnClickListener {
            viewModel.onEvent(OnboardingEvent.GetStartedEvent)
        }
    }

    private fun observerEvents() {
        lifecycleScope.launchWhenCreated {
            viewModel.viewEffect.collect {
                observerEffects(it)
            }
        }
    }

    private fun observerEffects(effect: OnboardingViewEffect) {
        when (effect) {
            OnboardingViewEffect.GetStartedViewEffect -> {
                actionByGetStarted()
            }
            OnboardingViewEffect.NextViewEffect -> {
                actionByNext()
            }
            OnboardingViewEffect.SkipViewEffect -> {
                actionBySkip()
            }
        }
    }

    private fun actionBySkip() {
        binding.viewPager.currentItem = viewModel.lists.size - 1
        setVisible()
    }

    private fun actionByGetStarted() {
        navigator.navigateToHome()
    }

    private fun actionByNext() {
        position = binding.viewPager.currentItem

        if (position < viewModel.lists.size) {
            position++
            binding.viewPager.currentItem = position
        }
        if (position == viewModel.lists.size - 1) {
            setVisible()
        }
    }


    private fun setVisible() = with(binding) {
        tvNext.hide()
        tvSkip.hide()
        dotsIndicator.hide()

        btnGetStarted.show()
    }
}