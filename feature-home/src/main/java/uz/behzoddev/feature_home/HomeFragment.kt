package uz.behzoddev.feature_home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.PagerSnapHelper
import com.tejpratapsingh.recyclercalendar.model.RecyclerCalendarConfiguration
import dagger.hilt.android.AndroidEntryPoint
import uz.behzoddev.feature_home.databinding.FragmentHomeBinding
import java.util.*

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!
    private lateinit var calendarAdapter : HorizontalCalendarAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerConfiguration()
    }

    private fun setupRecyclerConfiguration() {

        val date = Date()
        date.time = System.currentTimeMillis()

        val startCalendar = Calendar.getInstance()
        val endCalendar = Calendar.getInstance()

        endCalendar.time = date
        endCalendar.add(Calendar.MONTH,1)

        val configuration =
            RecyclerCalendarConfiguration(
                calenderViewType = RecyclerCalendarConfiguration.CalenderViewType.HORIZONTAL,
                calendarLocale = Locale.getDefault(),
                includeMonthHeader = true
            )

        configuration.weekStartOffset = RecyclerCalendarConfiguration.START_DAY_OF_WEEK.SUNDAY

        calendarAdapter = HorizontalCalendarAdapter(
            startDate = startCalendar.time,
            endDate = endCalendar.time,
            configuration = configuration,
            selectedDate = date,

            dateSelectListener = object : HorizontalCalendarAdapter.OnDateSelected {
                override fun onDateSelected(date: Date) {

                }
            }
        )

        binding.rvCalendar.adapter = calendarAdapter

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.rvCalendar)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }



}