package com.example.hw1a2.ui.Board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.hw1a2.Prefs
import com.example.hw1a2.R
import com.example.hw1a2.databinding.FragmentBoardBinding
import com.example.hw1a2.databinding.FragmentDashboardBinding
import com.example.hw1a2.databinding.FragmentSecondBinding
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class BoardFragment : Fragment() {
    private lateinit var binding: FragmentBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBoardBinding.inflate(LayoutInflater.from(requireContext()),container,false)
    return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BoardAdapter( requireContext(),findNavController())
        binding.viewPager.adapter = adapter

        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner){
            activity?.finish()
        }

        binding.skip.setOnClickListener {
            Prefs(requireContext()).saveState()
            findNavController().navigateUp()
        }
    }
}