package io.github.jimiwrd.dinacapi.service.impl

import io.github.jimiwrd.dinacapi.service.WeatherApiClient
import io.github.jimiwrd.dinacapi.service.dinacService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class dinacServiceImpl @Autowired constructor(private val weatherApiClient: WeatherApiClient): dinacService{
    override fun doINeedACoat(location: String): Boolean {
        val response = weatherApiClient.callToWeatherApi(location)
        println(response)
        return true;
    }

}