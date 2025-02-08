package com.example.practic.themes.sdk_4.practice_block.router

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.practic.R
import com.example.practic.databinding.SdkFragmentOneBinding
import com.example.practic.databinding.SdkFragmentTwoBinding


class TwoFragment : Fragment() {

    private lateinit var binding: SdkFragmentTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SdkFragmentTwoBinding.inflate(inflater)
        return binding.root
    }

}
