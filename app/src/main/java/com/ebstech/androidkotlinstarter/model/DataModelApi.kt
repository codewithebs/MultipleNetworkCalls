package com.ebstech.androidkotlinstarter.model

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface DataModelApi {

    @GET("/v2/time")
    fun getData(): Single<DataModel>

}