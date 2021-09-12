package com.meli.shop.features.main.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.meli.shop.data.Result
import androidx.lifecycle.Observer
import com.meli.shop.databinding.MainFragmentBinding
import com.meli.shop.di.Injectable
import com.meli.shop.features.BaseFragment
import timber.log.Timber
import javax.inject.Inject

class MainFragment : BaseFragment(), Injectable {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MainViewModel
    lateinit var mAdapter: ProductAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        mAdapter = ProductAdapter(requireContext())
        binding.recyclerViewSearchResults.adapter = mAdapter

        getProducts()
    }

    private fun getProducts() {
        viewModel.getProducts("lego").observe(requireActivity(), Observer { resultado ->
            when (resultado.status) {
                Result.Status.SUCCESS -> {
                    showProgressBar(false)
                    resultado.data?.let {
                        Timber.tag("resultado del service").i(it.results.joinToString { it.title })
                        mAdapter.setItems(it.results as MutableList)
                    }
                }
                Result.Status.LOADING -> {
                    showProgressBar(true)
                    Timber.tag("loading").i("loading")
                }
                Result.Status.ERROR -> {
                    showProgressBar(false)
                    Timber.tag("resultado del service").i(resultado.message)
                }
            }
        })
    }

}