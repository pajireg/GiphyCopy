package com.sumin.giphycopy

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.EditText
import androidx.fragment.app.Fragment
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
    ): View {
        val binding = FragmentUserBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.favoriteList.adapter = UserAdapter(
                // 이미지 전체 클릭했을때
                UserAdapter.OnClickListener {

                }
                // 좋아요 버튼 클릭해서 목록에서 지우기
                ,UserAdapter.DeleteFavoriteListener {
                    viewModel.deleteFavorite(it)
                }
        )
        return binding.root
    }
}