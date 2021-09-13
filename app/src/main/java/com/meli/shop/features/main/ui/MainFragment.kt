package com.meli.shop.features.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView.OnEditorActionListener
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.meli.shop.data.Result
import com.meli.shop.databinding.MainFragmentBinding
import com.meli.shop.di.Injectable
import com.meli.shop.features.BaseFragment
import com.meli.shop.utils.hideKeyboard
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

        binding.editTextSearch.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                binding.editTextSearch.clearFocus()
                hideKeyboard()
                if (binding.editTextSearch.text.toString().isNotEmpty()){
                    getProducts(binding.editTextSearch.text.toString())
                }else{
                    viewModel.products.value = listOf()
                }

                return@OnEditorActionListener true
            }
            false
        })

        binding.editTextSearch.doAfterTextChanged {
            if (binding.editTextSearch.text.toString().isEmpty()) binding.imageClear.visibility = View.INVISIBLE
            else binding.imageClear.visibility = View.VISIBLE
        }

        binding.imageClear.setOnClickListener {
            binding.editTextSearch.setText("")
            binding.editTextSearch.clearFocus()
            viewModel.products.value = listOf()
            hideKeyboard()
        }

        viewModel.products.observe(requireActivity(), Observer {
            mAdapter.setItems(it)
            if (it.isEmpty()) binding.noProducts.visibility = View.VISIBLE
            else binding.noProducts.visibility = View.GONE
        })
    }

    private fun getProducts(value:String) {
        viewModel.getProducts(value).observe(requireActivity(), Observer { resultado ->
            when (resultado.status) {
                Result.Status.SUCCESS -> {
                    showProgressBar(false)
                    resultado.data?.let {
                        Timber.tag("resultado del service").i(it.joinToString { it.title.toString() })
                        viewModel.products.value = it
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