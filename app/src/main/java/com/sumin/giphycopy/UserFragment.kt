package com.sumin.giphycopy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.sumin.giphycopy.adapters.UserAdapter
import com.sumin.giphycopy.databinding.FragmentUserBinding
import com.sumin.giphycopy.viewmodels.TrendingViewModel
import com.sumin.giphycopy.viewmodels.UserViewModel

class UserFragment : Fragment() {

    private val viewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUserBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.favoriteList.adapter = UserAdapter(
            UserAdapter.OnClickListener {

            }
        )
        return binding.root
    }

}