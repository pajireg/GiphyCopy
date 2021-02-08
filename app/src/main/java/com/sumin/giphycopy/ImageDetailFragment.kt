package com.sumin.giphycopy

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.sumin.giphycopy.data.Data
import com.sumin.giphycopy.databinding.FragmentImageDetailBinding
import com.sumin.giphycopy.viewmodels.ImageDetailViewModel
import com.sumin.giphycopy.viewmodels.ImageDetailViewModelFactory

private const val ARG_DATA = "data"

class ImageDetailFragment : Fragment() {
    private var data: Data? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            data = it.getParcelable(ARG_DATA)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentImageDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val application = requireNotNull(activity).application
        val viewModelFactory = data?.let { ImageDetailViewModelFactory(it, application) }
        val viewModel = viewModelFactory?.let {
            ViewModelProvider(this,
                it
            ).get(ImageDetailViewModel::class.java)
        }
        binding.viewModel = viewModel

        // 좋아요 누름
        binding.favoriteButton.setOnClickListener {
            Log.i("imageDetail", "favorite")
            viewModel?.getFavorite()
        }
        viewModel?.isFavorite?.observe(viewLifecycleOwner, {
            when (it) {
                true -> binding.favoriteButton.setImageResource(R.drawable.ic_baseline_thumb_up_48)
                else -> binding.favoriteButton.setImageResource(R.drawable.ic_outline_thumb_up_48)
            }
        })

        // 뒤로가기
        binding.toolbar.setNavigationOnClickListener { view ->
            view.findNavController().navigateUp()
        }
        return binding.root
    }
}