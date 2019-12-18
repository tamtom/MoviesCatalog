package com.tamimi.movies.ui

import android.widget.ImageView
import coil.api.load
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.tamimi.movies.R
import com.tamimi.movies.model.Movie

/**
 * Created by omaraltamimi on 18,December,2019
 */
class MoviesAdapter : BaseQuickAdapter<Movie, BaseViewHolder>(R.layout.item_movie) {
    override fun convert(helper: BaseViewHolder, item: Movie?) {
        item?.let {
            helper.getView<ImageView>(R.id.ivMovie)
                .load("http://image.tmdb.org/t/p/w185" + item.backDropUrl) {
                    crossfade(true)
                    placeholder(R.drawable.ic_holder)
                }
        }
    }
}