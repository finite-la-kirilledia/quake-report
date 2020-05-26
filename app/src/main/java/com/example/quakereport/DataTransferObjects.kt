package com.example.quakereport

fun UsgsResponse.asDomainModel(): List<Quake> {
    return features.map {
        Quake(
            it.properties.mag,
            it.properties.place,
            it.properties.time
        )
    }
}

data class UsgsResponse(
    val features: List<Feature>
)

data class Feature(
    val properties: Properties
)

data class Properties(
    val mag: Double,
    val place: String,
    val time: Long
)
