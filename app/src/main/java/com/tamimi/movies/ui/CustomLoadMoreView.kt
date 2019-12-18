package com.tamimi.movies.ui

import com.chad.library.adapter.base.loadmore.LoadMoreView
import com.tamimi.movies.R

/**
 * Created by omaraltamimi on 18,December,2019
 */
class CustomLoadMoreView : LoadMoreView() {

    override fun getLayoutId(): Int {
        return R.layout.view_load_more
    }

    override fun getLoadingViewId(): Int = R.id.pr_load_more

    override fun getLoadEndViewId(): Int {
        return 0
    }

    override fun getLoadFailViewId(): Int {
        return R.id.failure
    }

}