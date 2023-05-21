package com.yusuf.lkeleruygulamas.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yusuf.lkeleruygulamas.R
import com.yusuf.lkeleruygulamas.util.downloadFromUri
import com.yusuf.lkeleruygulamas.viewmodel.DetailsViewModel
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {
    private lateinit var viewModel : DetailsViewModel
    var countryUuid : Int = 10
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            countryUuid = DetailsFragmentArgs.fromBundle(it).countryUuid
        }
        Toast.makeText(requireContext(),"$countryUuid",Toast.LENGTH_SHORT).show()
        viewModel.loadingData()
        getData()
    }
    fun getData(){
        viewModel.SelectedCountry.observe(viewLifecycleOwner, Observer {selectedCountry ->
            selectedCountry?.let {country ->
                details_NameText.text = country.name
                details_BaskentText.text = country.capital
                details_KitasiText.text = country.region
                details_ParaBirimiText.text = country.currency
                details_imageView.downloadFromUri(country.flag)
            }
        })
    }
}