package com.example.prathamchikitse.data.model

data class EmergencyGuide(
    val id: String,
    val title: String,
    val steps: List<String>,
    val dos: List<String>,
    val donts: List<String>,
    val tileColorHex: String
)
