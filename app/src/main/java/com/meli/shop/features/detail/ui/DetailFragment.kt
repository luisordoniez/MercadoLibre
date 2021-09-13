package com.meli.shop.features.detail.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.gson.Gson
import com.meli.shop.R
import com.meli.shop.databinding.FragmentDetailBinding
import timber.log.Timber

/**
 * Created by Luis Ordoñez on 12/09/2021.
 */

class DetailFragment : Fragment(), View.OnClickListener, Toolbar.OnMenuItemClickListener {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbar.inflateMenu(R.menu.product)
        binding.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back)
        binding.toolbar.title = getString(R.string.detail)
        binding.toolbar.setOnMenuItemClickListener(this)
        binding.toolbar.setNavigationOnClickListener(this)

        val gson = Gson()
        val jsonTut: String = gson.toJson(args.product)
        binding.parametro.text = jsonTut
        Timber.tag("argumento").i(jsonTut)
    }

    override fun onClick(p0: View?) {
        requireActivity().onBackPressed()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.share->{
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, args.product.permalink)
                    type = "text/plain"
                }

                val shareIntent = Intent.createChooser(sendIntent, getString(R.string.share))
                startActivity(shareIntent)
            }
        }
        return false
    }
}