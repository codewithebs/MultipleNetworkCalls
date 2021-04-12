package com.ebstech.androidkotlinstarter.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ebstech.androidkotlinstarter.model.Data
import com.ebstech.androidkotlinstarter.model.DataModel
import com.ebstech.androidkotlinstarter.repo.DataRepo

class UserViewModel : ViewModel() {
    var _age = MutableLiveData(22)
    val age : LiveData<Int> = _age
    var repo = DataRepo()

    fun aging() {
        _age.value = (_age.value ?:0)+1
    }

    private fun requestData()
    {
        repo.requestData()
    }

    fun getLiveData():LiveData<Data>
    {
        requestData()
        return repo.getLiveData()
    }

}