package com.ebstech.androidkotlinstarter.model

import com.google.gson.annotations.SerializedName

class DataModel {
    @SerializedName("data")
    val data : Data? = null
}

class Data()
{
    @SerializedName("iso")
    val iso: String? = null

    @SerializedName("epoch")
    val epouch: Int? = null
}

