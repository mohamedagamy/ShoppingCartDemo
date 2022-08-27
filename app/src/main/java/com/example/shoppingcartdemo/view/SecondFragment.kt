package com.example.shoppingcartdemo.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.shoppingcartdemo.databinding.FragmentSecondBinding
import com.example.shoppingcartdemo.viewmodel.CartManager

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCart.adapter = CartAdapter(CartManager.selectedCartItems,context)
        binding.tvTotal.text = "Total is ${CartManager.calcTotal()}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}