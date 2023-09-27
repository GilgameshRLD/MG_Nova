package com.example.education_hackathon

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.education_hackathon.databinding.FragmentQuimicaBinding

class Quimica : Fragment() {
    private  var fbinding: FragmentQuimicaBinding?=null
    private val binding get() = fbinding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentQuimicaBinding.inflate(inflater,container,false)
        val view: View = binding.root
        return view
    }
    override fun onDestroyView() {
        super.onDestroyView()
        fbinding = null
    }

}