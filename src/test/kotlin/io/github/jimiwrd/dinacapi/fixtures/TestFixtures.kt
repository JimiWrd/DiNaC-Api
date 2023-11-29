package io.github.jimiwrd.dinacapi.fixtures

import io.github.jimiwrd.dinacapi.model.WeatherResponseModel

class TestFixtures {
    companion object {
        fun generateCoatNeededMinTempModel(): WeatherResponseModel {
            return WeatherResponseModel(
                address = "birmingham",
                latitude = 52.4789,
                longitude = -1.90592,
                queryCost = 1,
                resolvedAddress = "Birmingham, England, United Kingdom",
                timezone = "Europe/London",
                tzoffset = 0.0,
                days = listOf(
                    WeatherResponseModel.Day(
                        description = "Partly cloudy throughout the day with early morning rain.",
                        precip = 0.1,
                        tempmax = 12.0,
                        tempmin = 9.0
                    )
                )
            )
        }

        fun generateCoatNeededRainModel(): WeatherResponseModel {
            return WeatherResponseModel(
                address = "birmingham",
                latitude = 52.4789,
                longitude = -1.90592,
                queryCost = 1,
                resolvedAddress = "Birmingham, England, United Kingdom",
                timezone = "Europe/London",
                tzoffset = 0.0,
                days = listOf(
                    WeatherResponseModel.Day(
                        description = "Partly cloudy throughout the day with early morning rain.",
                        precip = 0.5,
                        tempmax = 12.0,
                        tempmin = 11.0
                    )
                )
            )
        }

        fun generateCoatNotNeededModel(): WeatherResponseModel {
            return WeatherResponseModel(
                address = "birmingham",
                latitude = 52.4789,
                longitude = -1.90592,
                queryCost = 1,
                resolvedAddress = "Birmingham, England, United Kingdom",
                timezone = "Europe/London",
                tzoffset = 0.0,
                days = listOf(
                    WeatherResponseModel.Day(
                        description = "Partly cloudy throughout the day with early morning rain.",
                        precip = 0.1,
                        tempmax = 12.0,
                        tempmin = 11.0
                    )
                )
            )
        }
    }
}