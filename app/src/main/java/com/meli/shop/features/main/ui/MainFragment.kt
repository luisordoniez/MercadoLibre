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
import com.meli.shop.features.main.data.entity.Product
import dagger.android.support.DaggerFragment
import timber.log.Timber
import javax.inject.Inject

class MainFragment : DaggerFragment(), Injectable {

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

        val listMovies = mutableListOf<Product>()
        listMovies.add(Product())
        listMovies.add(Product())
        listMovies.add(Product())
        listMovies.add(Product())
        listMovies.add(Product())
        listMovies.add(Product())
        mAdapter.setItems(listMovies)

        getCounters()
    }

    private fun getCounters() {
        viewModel.getProducts("lego").observe(requireActivity(), Observer { resultado ->
            when (resultado.status) {
                Result.Status.SUCCESS -> {
                    resultado.data?.let {
                        Timber.tag("resultado del service").i(it.results.joinToString { it.title })
                        Toast.makeText(context,"succsses", Toast.LENGTH_LONG).show()
                    }
                }
                Result.Status.LOADING -> Timber.tag("loading").i("loading")
                Result.Status.ERROR -> {
                    Toast.makeText(context,resultado.message, Toast.LENGTH_LONG).show()
                    Timber.tag("resultado del service").i(resultado.message)
                }
            }
        })
    }

}