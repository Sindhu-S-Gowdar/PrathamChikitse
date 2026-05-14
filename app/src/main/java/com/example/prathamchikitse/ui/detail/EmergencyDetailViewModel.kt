package com.example.prathamchikitse.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.prathamchikitse.data.model.EmergencyGuide
import com.example.prathamchikitse.data.repository.FirstAidRepository
import com.example.prathamchikitse.language.AppLanguage

class EmergencyDetailViewModel : ViewModel() {
    private val _guide = MutableLiveData<EmergencyGuide?>()
    val guide: LiveData<EmergencyGuide?> = _guide

    fun loadGuide(id: String, language: AppLanguage) {
        _guide.value = FirstAidRepository.getEmergencyGuideById(id, language)
    }
}
