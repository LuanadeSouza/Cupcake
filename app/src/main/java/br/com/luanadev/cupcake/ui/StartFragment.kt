package br.com.luanadev.cupcake.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import br.com.luanadev.cupcake.R
import br.com.luanadev.cupcake.databinding.FragmentStartBinding
import br.com.luanadev.cupcake.model.OrderViewModel
import by.kirich1409.viewbindingdelegate.viewBinding

class StartFragment : Fragment() {

    private val binding by viewBinding{
         FragmentStartBinding.inflate(layoutInflater)
    }
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    )= binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.startFragment = this
    }

    fun orderCupcake(quantity: Int) {
        sharedViewModel.setQuantity(quantity)
        if (sharedViewModel.hasNoFlavorSet()) {
            sharedViewModel.setFlavor(getString(R.string.vanilla))
        }
        findNavController().navigate(R.id.action_startFragment_to_flavorFragment)
    }
}