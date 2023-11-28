package io.github.jimiwrd.dinacapi.service

import org.springframework.http.ResponseEntity

interface WeatherApiClient {
    fun callToWeatherApi(location: String): ResponseEntity<String>
}