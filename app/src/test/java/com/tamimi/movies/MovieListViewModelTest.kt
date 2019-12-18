package com.tamimi.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.whenever
import com.tamimi.movies.model.Movie
import com.tamimi.movies.model.Resource
import com.tamimi.movies.model.SortBy
import com.tamimi.movies.repository.MoviesListRepository
import com.tamimi.movies.viewmodels.MoviesViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Created by omaraltamimi on 18,December,2019
 */
@RunWith(JUnit4::class)
class MovieListViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule
    var testCoroutineRule = CoroutinesTestRule()
    @Mock
    lateinit var moviesListRepository: MoviesListRepository
    @Mock
    lateinit var viewStateObserver: Observer<Resource<List<Movie>>>
    lateinit var moviesViewModel: MoviesViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        moviesViewModel = MoviesViewModel(moviesListRepository).apply {
            popularMovies.observeForever(viewStateObserver)
            topRated.observeForever(viewStateObserver)
            topRevenue.observeForever(viewStateObserver)
        }
    }

    @ExperimentalCoroutinesApi
    @Test
    fun loadPopular_success() = testCoroutineRule.testDispatcher.runBlockingTest {

        val data = listOf(Movie("This is a test movie", "This is important note"))

        whenever(moviesListRepository.getMovies(1, SortBy.POPULARITY)).thenReturn(
            Resource.success(
                data
            )
        )

        moviesViewModel.fetchPopular()

        val orderVerifier = Mockito.inOrder(viewStateObserver)

        orderVerifier.verify(viewStateObserver).onChanged(Resource.loading(null))
        orderVerifier.verify(viewStateObserver).onChanged(Resource.success(data))
    }
    @ExperimentalCoroutinesApi
    @Test
    fun loadTop_success() = testCoroutineRule.testDispatcher.runBlockingTest {

        val data = listOf(Movie("This is a test movie top", "This is important note"))

        whenever(moviesListRepository.getMovies(1, SortBy.TOP_RATED)).thenReturn(
            Resource.success(
                data
            )
        )

        moviesViewModel.fetchTopRated()

        val orderVerifier = Mockito.inOrder(viewStateObserver)

        orderVerifier.verify(viewStateObserver).onChanged(Resource.loading(null))
        orderVerifier.verify(viewStateObserver).onChanged(Resource.success(data))
    }
    @ExperimentalCoroutinesApi
    @Test
    fun loadRevenue_success() = testCoroutineRule.testDispatcher.runBlockingTest {

        val data = listOf(Movie("This is a test movie revenue", "This is important note"))

        whenever(moviesListRepository.getMovies(1, SortBy.REVENUE)).thenReturn(
            Resource.success(
                data
            )
        )

        moviesViewModel.fetchRevenue()

        val orderVerifier = Mockito.inOrder(viewStateObserver)

        orderVerifier.verify(viewStateObserver).onChanged(Resource.loading(null))
        orderVerifier.verify(viewStateObserver).onChanged(Resource.success(data))
    }

}