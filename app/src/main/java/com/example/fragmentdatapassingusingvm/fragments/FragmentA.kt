package com.example.fragmentdatapassingusingvm.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.fragmentdatapassingusingvm.R
import com.example.fragmentdatapassingusingvm.databinding.ActivityMainBinding
import com.example.fragmentdatapassingusingvm.databinding.FragmentABinding
import com.example.fragmentdatapassingusingvm.viewmodel.MainViewModel

class FragmentA : Fragment(R.layout.fragment_a) {

    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!
    private val mainViewModel: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.text.observe(requireActivity(), Observer { data->
            binding.ed1.setText(data)
        })
        binding.btn1.setOnClickListener {
            mainViewModel.saveCountry(binding.ed1.text.toString())
            val direction =FragmentADirections.actionFragmentAToFragmentB()
            findNavController().navigate(direction)
        }
    }
}