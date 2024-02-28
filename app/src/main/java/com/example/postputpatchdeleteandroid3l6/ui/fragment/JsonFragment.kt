package com.example.postputpatchdeleteandroid3l6.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postputpatchdeleteandroid3l6.R
import com.example.postputpatchdeleteandroid3l6.databinding.FragmentJsonBinding
import com.example.postputpatchdeleteandroid3l6.ui.activity.JsonViewModel
import com.example.postputpatchdeleteandroid3l6.ui.adapter.JsonAdapter

class JsonFragment : Fragment() {

    private var _binding: FragmentJsonBinding? = null
    private val binding get() = _binding!!
    private val jsonAdapter = JsonAdapter()
    private val  viewModel by activityViewModels<JsonViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJsonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    setupListener()
        initialize()
        Log.e("room", "onViewCreated: ${viewModel.fetchData()}", )
        jsonAdapter.setJsonList(viewModel.fetchData())
    }

    private fun initialize() {
        binding.rvJson.layoutManager = LinearLayoutManager(requireContext())
        binding.rvJson.adapter = jsonAdapter
    }

    private fun setupListener() {
        binding.arrow.setOnClickListener {
            findNavController().navigate(R.id.action_jsonFragment_to_mainFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}