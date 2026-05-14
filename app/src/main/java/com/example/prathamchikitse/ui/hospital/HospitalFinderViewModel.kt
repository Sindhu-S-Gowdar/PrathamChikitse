package com.example.prathamchikitse.ui.hospital

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.prathamchikitse.data.model.Hospital
import com.example.prathamchikitse.data.repository.FirstAidRepository
import com.example.prathamchikitse.language.AppLanguage

class HospitalFinderViewModel : ViewModel() {
    private val _hospitals = MutableLiveData<List<Hospital>>()
    val hospitals: LiveData<List<Hospital>> = _hospitals

    fun loadHospitals(language: AppLanguage) {
        _hospitals.value = FirstAidRepository.getHospitals(language)
    }
}
