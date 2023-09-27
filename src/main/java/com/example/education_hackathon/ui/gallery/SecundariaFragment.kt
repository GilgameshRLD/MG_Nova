package com.example.education_hackathon.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.education_hackathon.R
import com.example.education_hackathon.databinding.FragmentSecundariaBinding

class SecundariaFragment : Fragment() {

    private var fbinding: FragmentSecundariaBinding?= null
    private val binding get() = fbinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fbinding = FragmentSecundariaBinding.inflate(inflater,container,false)
        val view: View = binding.root

        binding.imageHistoria.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.historia)
        }
        binding.imageQuimica.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.quimica)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }
}