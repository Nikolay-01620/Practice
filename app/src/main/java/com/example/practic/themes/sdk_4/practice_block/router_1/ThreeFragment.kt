package com.example.practic.themes.sdk_4.practice_block.router_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practic.R
import com.example.practic.databinding.SdkFragmentThreeBinding
import com.example.practic.databinding.SdkFragmentTwoBinding


class ThreeFragment : Fragment() {

    private lateinit var binding: SdkFragmentThreeBinding
    private lateinit var router: FragmentRouter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SdkFragmentThreeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        router = FragmentRouter(requireActivity())
        binding.buttonPrev3.setOnClickListener {
            router.goBack()
        }
    }
}