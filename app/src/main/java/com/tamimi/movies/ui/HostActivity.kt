package com.tamimi.movies.ui

import android.os.Bundle
import com.tamimi.movies.R
import com.tamimi.movies.ui.base.BaseDaggerActivity

class HostActivity : BaseDaggerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}