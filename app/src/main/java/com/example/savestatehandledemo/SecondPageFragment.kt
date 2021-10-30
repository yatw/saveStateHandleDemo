package com.example.savestatehandledemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.navGraphViewModels
import com.example.savestatehandledemo.databinding.FragmentSecondpageBinding

class SecondPageFragment: Fragment() {

    private val myViewModel: MyViewModel by navGraphViewModels(R.id.nav_mission){
        MyViewModel.Factory(requireActivity(), "hello world2")
    }

    private lateinit var binding: FragmentSecondpageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondpageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(requireContext(), "second page ${myViewModel.doubleTheInput()}", Toast.LENGTH_SHORT).show()

        binding.btn.setOnClickListener {
            requireActivity().findNavController(R.id.main_nav_host).navigateUp()
        }

    }

}