package com.ernestkoko.viewpager.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ernestkoko.viewpager.R
import com.ernestkoko.viewpager.screens.FirstScreen
import com.ernestkoko.viewpager.screens.SecondScreen
import com.ernestkoko.viewpager.screens.ThirdScreen
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_view_pager.view.*


class ViewPagerFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )

        val adapter =
            ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)

        val pager = view.viewPager2
        val tabLayout = view.myTabLayout
        pager.adapter = adapter
        TabLayoutMediator(tabLayout,pager){tab, position ->
            tab.text = "Object ${position + 1}"
        }.attach()


        return view
    }

}