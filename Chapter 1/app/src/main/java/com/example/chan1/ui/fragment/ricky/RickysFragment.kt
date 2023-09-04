package com.example.chan1.ui.fragment.ricky

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chan1.adapter.RickysViewpagerAdapter
import com.example.chan1.databinding.FragmentRickysBinding
import com.example.chan1.utils.initializeInventory

import com.google.android.material.tabs.TabLayoutMediator


class RickysFragment : Fragment() {

    private lateinit var binding: FragmentRickysBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRickysBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeInventory()
        val categoriesFragments =
            arrayListOf(
                AddGuitarFragment(),
                GetGuitarFragment(),

                )
        val viewPagerAdapter =
            RickysViewpagerAdapter(categoriesFragments, childFragmentManager, lifecycle)
        binding.apply {
            viewPager.adapter = viewPagerAdapter
            tabLayout.setSelectedTabIndicator(null)
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                when (position) {
                    0 -> tab.text = "Add Guitar"
                    1 -> tab.text = "Get Guitar"
                }

            }.attach()
        }

    }


}