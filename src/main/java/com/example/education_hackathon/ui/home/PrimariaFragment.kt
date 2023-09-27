package com.example.education_hackathon.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.education_hackathon.R
import com.example.education_hackathon.databinding.FragmentPrimariaBinding

class PrimariaFragment : Fragment() {
    private var fbinding: FragmentPrimariaBinding?= null
    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       fbinding = FragmentPrimariaBinding.inflate(inflater,container,false)
        val view: View = binding.root

        binding.imageSpanish.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.spanish)
        }
        binding.imageMat.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.matematica)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }
}