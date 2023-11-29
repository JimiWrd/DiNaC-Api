package io.github.jimiwrd.dinacapi.model

data class WeatherResponseModel(
    val address: String,
    val days: List<Day>,
    val latitude: Double,
    val longitude: Double,
    val queryCost: Int,
    val resolvedAddress: String,
    val timezone: String,
    val tzoffset: Double
) {
    data class Day(
        val description: String,
        val precip: Double,
        val tempmax: Double,
        val tempmin: Double
    )
}