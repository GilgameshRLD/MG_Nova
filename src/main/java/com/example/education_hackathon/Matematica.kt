package com.example.education_hackathon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.education_hackathon.databinding.FragmentMatematicaBinding

class Matematica : Fragment() {
    private  var fbinding: FragmentMatematicaBinding?=null
    private val binding get() = fbinding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentMatematicaBinding.inflate(inflater,container,false)
        val view: View = binding.root
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }

}