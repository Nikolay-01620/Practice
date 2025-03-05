package com.example.practic.themes.sdk_4.practice_block.router_1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.practic.R
import com.example.practic.databinding.SdkFragmentOneBinding

class OneFragment : Fragment() {

    private lateinit var binding: SdkFragmentOneBinding
    private lateinit var router: FragmentRouter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SdkFragmentOneBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        router = FragmentRouter(requireActivity())

        binding.buttonNext.setOnClickListener {
            router.navigateTo(TwoFragment())
        }
    }
}
