package uz.behzoddev.feature_splash

import android.os.Bundle
import android.view.Window
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import uz.behzoddev.feature_splash.databinding.ActivitySplashBinding
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModels()

    @Inject
    lateinit var navigator: SplashNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()

        observeEvents()
    }

    private fun setupUI() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

    }

    private fun observeEvents() {
        this.lifecycleScope.launchWhenCreated {
            viewModel.onEvent(SplashEvent.MainEvent)
            viewModel.viewEffects.collect {
                listenerEvents(it)
            }
        }
    }

    private fun listenerEvents(effects: SplashViewEffects) {
        when (effects) {
            SplashViewEffects.MainViewEffects -> {
                navigator.navigateToMain()
            }
        }
    }
}