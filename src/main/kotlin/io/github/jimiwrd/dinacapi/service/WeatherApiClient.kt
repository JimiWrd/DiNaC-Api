package io.github.jimiwrd.dinacapi.service

import io.github.jimiwrd.dinacapi.model.WeatherResponseModel

interface WeatherApiClient {
    fun callToWeatherApi(location: String): WeatherResponseModel
}