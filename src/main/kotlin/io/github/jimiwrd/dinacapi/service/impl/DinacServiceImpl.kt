package io.github.jimiwrd.dinacapi.service.impl

import io.github.jimiwrd.dinacapi.dto.DinacResponseDto
import io.github.jimiwrd.dinacapi.model.WeatherResponseModel
import io.github.jimiwrd.dinacapi.service.DinacService
import io.github.jimiwrd.dinacapi.service.WeatherApiClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DinacServiceImpl @Autowired constructor(private val weatherApiClient: WeatherApiClient): DinacService{
    override fun doINeedACoat(location: String): DinacResponseDto {
        val apiResponse = weatherApiClient.callToWeatherApi(location)

        val isCoatNeeded = determineIfCoatNeeded(apiResponse)

        return DinacResponseDto(isCoatNeeded, apiResponse.days[0].description)
    }

    private fun determineIfCoatNeeded(apiResponse: WeatherResponseModel): Boolean {
//      If precipitation is greater than 0.4mm (light drizzle) coat is needed
        if(apiResponse.days[0].precip > 0.4) return true

//      If temp will be below 10 degrees Celsius at any point then coat is needed
        if(apiResponse.days[0].tempmin < 10.0) return true

        return false
    }

}