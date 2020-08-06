package com.axxess.imageloader.models

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class AdConfig(
    @get:JsonProperty("highRiskFlags")
    @set:JsonProperty("highRiskFlags")
    @JsonProperty("highRiskFlags")
    var highRiskFlags: List<String>,
    @get:JsonProperty("safeFlags")
    @set:JsonProperty("safeFlags")
    @JsonProperty("safeFlags")
    var safeFlags: List<String>,
    @get:JsonProperty("showsAds")
    @set:JsonProperty("showsAds")
    @JsonProperty("showsAds")
    var showsAds: Boolean,
    @get:JsonProperty("unsafeFlags")
    @set:JsonProperty("unsafeFlags")
    @JsonProperty("unsafeFlags")
    var unsafeFlags: List<String>,
    @get:JsonProperty("wallUnsafeFlags")
    @set:JsonProperty("wallUnsafeFlags")
    @JsonProperty("wallUnsafeFlags")
    var wallUnsafeFlags: List<String>
) : Serializable {}