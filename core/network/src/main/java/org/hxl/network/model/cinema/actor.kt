package org.hxl.network.model.cinema


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class actor(
    @Json(name = "adult")
    val adult: Boolean?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "original_name")
    val originalName: String?,
    @Json(name = "media_type")
    val mediaType: String?,
    @Json(name = "popularity")
    val popularity: Double?,
    @Json(name = "gender")
    val gender: Int?,
    @Json(name = "known_for_department")
    val knownForDepartment: String?,
    @Json(name = "profile_path")
    val profilePath: String?
)