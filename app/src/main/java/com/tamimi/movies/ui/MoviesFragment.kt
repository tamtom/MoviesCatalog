package com.tamimi.movies.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tamimi.movies.R
import com.tamimi.movies.model.Resource
import com.tamimi.movies.model.SortBy
import com.tamimi.movies.ui.base.BaseDaggerFragment
import com.tamimi.movies.viewmodels.MoviesViewModel
import kotlinx.android.synthetic.main.movies_fragment.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class MoviesFragment : BaseDaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val moviesViewModel by viewModels<MoviesViewModel> { viewModelFactory }
    lateinit var popularAdapter: MoviesAdapter
    lateinit var topRatedAdapter: MoviesAdapter
    lateinit var revenueAdapter: MoviesAdapter

    companion object {
        fun newInstance() = MoviesFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRvAdapters()
        observeMovies()
        moviesViewModel.fetchPopular()
         moviesViewModel.fetchTopRated()
         moviesViewModel.fetchRevenue()
    }

    private fun initRvAdapters() {
        popularAdapter = MoviesAdapter()
        topRatedAdapter = MoviesAdapter()
        revenueAdapter = MoviesAdapter()
        rvPopular.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = popularAdapter
        }
        rvRated.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = topRatedAdapter
        }
        rvRevenue.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            adapter = revenueAdapter
        }

        setLoadMoreListener()

    }

    private fun setLoadMoreListener() {
        popularAdapter.setLoadMoreView(CustomLoadMoreView())
        topRatedAdapter.setLoadMoreView(CustomLoadMoreView())
        revenueAdapter.setLoadMoreView(CustomLoadMoreView())
        popularAdapter.setOnLoadMoreListener({
            moviesViewModel.fetchPopular()

        }, rvPopular)
        topRatedAdapter.setOnLoadMoreListener({
            moviesViewModel.fetchTopRated()
        }, rvRated)
        revenueAdapter.setOnLoadMoreListener({
            moviesViewModel.fetchRevenue()

        }, rvRevenue)
    }

    private fun observeMovies() {
        moviesViewModel.popularMovies.observe(viewLifecycleOwner, Observer { res ->
            when (res.status) {
                Resource.Status.LOADING -> {
                    if (moviesViewModel.isFirstPage(SortBy.POPULARITY)) {
                        prPopular.visibility = View.VISIBLE
                    }
                }

                Resource.Status.ERROR -> {
                }

                Resource.Status.SUCCESS -> {
                    prPopular.visibility = View.GONE
                    res.data?.let {
                        popularAdapter.addData(it)
                        popularAdapter.loadMoreComplete()

                    }
                }
            }
        }
        )
        moviesViewModel.topRated.observe(viewLifecycleOwner, Observer { res ->
            when (res.status) {
                Resource.Status.LOADING -> {
                    if (moviesViewModel.isFirstPage(SortBy.TOP_RATED)) {
                        prRated.visibility = View.VISIBLE
                    }
                }

                Resource.Status.ERROR -> {
                }

                Resource.Status.SUCCESS -> {
                    prRated.visibility = View.GONE
                    res.data?.let {
                        topRatedAdapter.addData(it)
                        topRatedAdapter.loadMoreComplete()
                    }

                }
            }

        })
        moviesViewModel.topRevenue.observe(viewLifecycleOwner, Observer { res ->
            when (res.status) {
                Resource.Status.LOADING -> {
                    if (moviesViewModel.isFirstPage(SortBy.REVENUE)) {
                        prRevenue.visibility = View.VISIBLE
                    }
                }

                Resource.Status.ERROR -> {
                }

                Resource.Status.SUCCESS -> {
                    prRevenue.visibility = View.GONE
                    res.data?.let {
                        revenueAdapter.addData(it)
                        revenueAdapter.loadMoreComplete()
                    }
                }
            }

        })
    }
}