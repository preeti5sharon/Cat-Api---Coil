package github.preeti5sharon.catapi.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CatResponseItem(
    val height: Int?,
    val id: String?,
    val url: String?,
    val width: Int?
)