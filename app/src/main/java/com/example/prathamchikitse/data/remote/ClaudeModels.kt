package com.example.prathamchikitse.data.remote

import com.google.gson.annotations.SerializedName

data class GeminiGenerateRequest(
    @SerializedName("system_instruction") val systemInstruction: GeminiInstruction,
    @SerializedName("contents") val contents: List<GeminiContent>
)

data class GeminiInstruction(
    @SerializedName("parts") val parts: List<GeminiPart>
)

data class GeminiContent(
    @SerializedName("role") val role: String? = null,
    @SerializedName("parts") val parts: List<GeminiPart>
)

data class GeminiPart(
    @SerializedName("text") val text: String?
)

data class GeminiGenerateResponse(
    @SerializedName("candidates") val candidates: List<GeminiCandidate>?
)

data class GeminiCandidate(
    @SerializedName("content") val content: GeminiContent?
)

