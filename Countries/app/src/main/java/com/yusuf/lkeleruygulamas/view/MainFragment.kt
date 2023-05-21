package com.yusuf.lkeleruygulamas.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.yusuf.lkeleruygulamas.R
import com.yusuf.lkeleruygulamas.adapter.CountryAdapter
import com.yusuf.lkeleruygulamas.model.Country
import com.yusuf.lkeleruygulamas.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    private lateinit var viewModel : MainViewModel
    val adapter = CountryAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.refreshData()
        recyclerViewCountry.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewCountry.adapter = adapter
        observeLiveData()
       /* swipeRefrehLayout.setOnRefreshListener {
            recyclerViewCountry.visibility = View.GONE
            textViewError.visibility = View.GONE
            countryLoadingProgressBar.visibility = View.VISIBLE
            viewModel.refreshData()
            swipeRefrehLayout.isRefreshing = false
        }

        */
    }
    fun observeLiveData(){
        viewModel.countries.observe(viewLifecycleOwner, Observer {countries ->
            countries?.let {
                recyclerViewCountry.visibility = View.VISIBLE
                adapter.updateCountryList(countries)
            }
        })
        viewModel.countryError.observe(viewLifecycleOwner, Observer {errorResult  ->
            errorResult?.let {
                if (errorResult){
                    textViewError.visibility = View.VISIBLE
                    recyclerViewCountry.visibility = View.GONE
                }else{
                    textViewError.visibility = View.GONE
                    recyclerViewCountry.visibility = View.VISIBLE
                }
            }
        })
        viewModel.countryLoading.observe(viewLifecycleOwner, Observer {loadingResult ->
            loadingResult?.let {
                if (it){
                    countryLoadingProgressBar.visibility = View.VISIBLE
                    recyclerViewCountry.visibility = View.GONE
                    textViewError.visibility = View.GONE
                }else{
                    countryLoadingProgressBar.visibility = View.GONE
                }
            }
        })
    }
}