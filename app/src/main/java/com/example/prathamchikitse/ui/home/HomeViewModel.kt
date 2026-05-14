package com.example.prathamchikitse.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.prathamchikitse.data.model.EmergencyGuide
import com.example.prathamchikitse.data.repository.FirstAidRepository
import com.example.prathamchikitse.language.AppLanguage

class HomeViewModel : ViewModel() {
    private val _emergencies = MutableLiveData<List<EmergencyGuide>>()
    val emergencies: LiveData<List<EmergencyGuide>> = _emergencies

    fun loadEmergencies(language: AppLanguage) {
        _emergencies.value = FirstAidRepository.getEmergencyGuides(language)
    }
}
