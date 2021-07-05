package com.example.fragmentdatapassingusingvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.fragmentdatapassingusingvm.R
import com.example.fragmentdatapassingusingvm.databinding.FragmentABinding
import com.example.fragmentdatapassingusingvm.databinding.FragmentBBinding
import com.example.fragmentdatapassingusingvm.viewmodel.MainViewModel


class FragmentB : Fragment(R.layout.fragment_b) {
    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!
    private val mainViewModel: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.text.observe(requireActivity(), Observer { data->
            binding.ed2.setText(data)
        })
        binding.btn2.setOnClickListener {
            mainViewModel.saveCountry(binding.ed2.text.toString())
            val direction =FragmentBDirections.actionFragmentBToFragmentA()
            findNavController().navigate(direction)
        }
    }

}