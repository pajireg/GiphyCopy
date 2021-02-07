package com.sumin.giphycopy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.sumin.giphycopy.adapters.TrendingAdapter
import com.sumin.giphycopy.databinding.FragmentTrendingBinding
import com.sumin.giphycopy.viewmodels.TrendingViewModel

class TrendingFragment : Fragment() {

    private lateinit var binding: FragmentTrendingBinding

    private val viewModel: TrendingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTrendingBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.trendingViewModel = viewModel
        binding.dataList.adapter = TrendingAdapter()
        return binding.root
    }
}