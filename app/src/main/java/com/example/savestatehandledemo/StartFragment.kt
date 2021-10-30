package com.example.savestatehandledemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.savestatehandledemo.databinding.FragmentStartpageBinding


class StartFragment: Fragment() {

    private lateinit var binding: FragmentStartpageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartpageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn.setOnClickListener {
            requireActivity().findNavController(R.id.main_nav_host).navigate(R.id.action_startFragment_to_nav_mission)
        }


    }

}