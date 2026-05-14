package com.example.prathamchikitse.ui.detail

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.prathamchikitse.data.model.EmergencyGuide

class InstructionPagerAdapter(
    activity: EmergencyDetailActivity,
    private val guide: EmergencyGuide
) : FragmentStateAdapter(activity) {

    // Pages:
    //  1..N  -> numbered steps
    //  N+1   -> Do's
    //  N+2   -> Don'ts
    override fun getItemCount(): Int = guide.steps.size + 2

    override fun createFragment(position: Int): Fragment {
        return when {
            position < guide.steps.size -> StepPageFragment.newInstance(position + 1, guide.steps[position])
            position == guide.steps.size -> DosPageFragment.newInstance(guide.dos)
            else -> DontsPageFragment.newInstance(guide.donts)
        }
    }
}
