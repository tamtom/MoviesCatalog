package com.tamimi.movies.di

import android.content.Context
import androidx.room.Room
import com.tamimi.movies.MoviesApplication
import com.tamimi.movies.api.MoviesService
import com.tamimi.movies.api.RequestInterceptor
import com.tamimi.movies.db.*
import com.tamimi.movies.repository.MovieDetailsRepository
import com.tamimi.movies.repository.MoviesListRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by omaraltamimi on 17,December,2019
 */
@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: MoviesApplication): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(interceptor)
            .addInterceptor(RequestInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(MoviesService.BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideMoviesService(retrofit: Retrofit): MoviesService {
        return retrofit.create()
    }

    @Provides
    @Singleton
    fun provideDatabase(context: Context): RoomDb {
        return Room.databaseBuilder(context, RoomDb::class.java, RoomDb.DATABASE_NAME)
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(database: RoomDb): MovieDao {
        return database.movieDao()
    }

    @Provides
    @Singleton
    fun provideReviewsDao(database: RoomDb): ReviewsDao {
        return database.reviewDao()
    }

    @Provides
    @Singleton
    fun provideVideosDao(database: RoomDb): VideosDao {
        return database.videoDao()
    }

    @Provides
    @Singleton
    fun provideMoviesWithTypeDao(database: RoomDb): MoviesAndTypeDao {
        return database.movieTypeDao()
    }

    @Provides
    @Singleton
    fun provideTypeDao(database: RoomDb): TypeDao {
        return database.typeDao()
    }

    @Provides
    @Singleton
    fun provideMovieListRepository(
        moviesService: MoviesService,
        moviesAndTypeDao: MoviesAndTypeDao,
        movieDao: MovieDao,
        typeDao: TypeDao
    ): MoviesListRepository {
        return MoviesListRepository(moviesService, moviesAndTypeDao, movieDao,typeDao)
    }

    @Provides
    @Singleton
    fun provideMovieDetailsRepository(
        moviesService: MoviesService,
        movieDao: MovieDao,
        reviewsDao: ReviewsDao,
        videosDao: VideosDao
    ): MovieDetailsRepository {
        return MovieDetailsRepository(moviesService, movieDao, reviewsDao, videosDao)
    }
}