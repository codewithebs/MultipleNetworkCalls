package com.ebstech.androidkotlinstarter.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ebstech.androidkotlinstarter.model.Data
import com.ebstech.androidkotlinstarter.model.DataModel
import com.ebstech.androidkotlinstarter.model.DataModelApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class DataRepo {
    var liveData = MutableLiveData<Data>()
    var apiClient : DataModelApi

    init {

        var httplogger  = HttpLoggingInterceptor()
        httplogger.level= HttpLoggingInterceptor.Level.BODY
        var client = OkHttpClient.Builder().addInterceptor(httplogger).build()

        var retrofit: Retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.coinbase.com")
            .build()
        apiClient = retrofit.create(DataModelApi::class.java)
    }

    fun requestData()
    {
        apiClient.getData()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<DataModel>(){
                override fun onSuccess(value: DataModel) {
                    liveData.postValue(value.data)
                    Log.d("Value Ove TIMe", " ${value.data?.iso}")
                    Log.d("Epoch OVer Time", "${value.data?.epouch}")
                }

                override fun onError(e: Throwable?) {
                    TODO("Not yet implemented")
                }

            })
    }
    fun getLiveData (): LiveData<Data>
    {
        return liveData
    }



}