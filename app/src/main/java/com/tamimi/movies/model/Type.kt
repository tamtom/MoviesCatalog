package com.tamimi.movies.model

import androidx.room.Entity

/**
 * Created by omaraltamimi on 17,December,2019
 */
@Entity(primaryKeys = [("typeId")])
class Type(val typeId: Int, val typeName: String)