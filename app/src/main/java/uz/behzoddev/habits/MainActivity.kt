package uz.behzoddev.habits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import uz.behzoddev.habits.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()

    }

    private fun setupUI() {
        binding.apply {
            binding.bottomNavigation.itemIconTintList = null
            binding.bottomNavigation.itemIconSize = resources.getDimension(R.dimen.dimen_20dp).toInt()
        }
    }
}