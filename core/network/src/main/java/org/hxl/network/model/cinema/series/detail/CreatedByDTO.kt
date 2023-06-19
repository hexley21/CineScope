package org.hxl.network.model.cinema.series.detail


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreatedByDTO(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "credit_id")
    val creditId: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "gender")
    val gender: Int?,
    @Json(name = "profile_path")
    val profilePath: String?
)