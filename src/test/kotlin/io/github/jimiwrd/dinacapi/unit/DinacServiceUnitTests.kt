package io.github.jimiwrd.dinacapi.unit

import io.github.jimiwrd.dinacapi.fixtures.TestFixtures
import io.github.jimiwrd.dinacapi.service.DinacService
import io.github.jimiwrd.dinacapi.service.WeatherApiClient
import io.github.jimiwrd.dinacapi.service.impl.DinacServiceImpl
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class DinacServiceUnitTests {

    private lateinit var mockWeatherApiClient: WeatherApiClient
    private lateinit var dinacService: DinacService

    @BeforeEach
    fun setup() {
        mockWeatherApiClient = mock()
        dinacService = DinacServiceImpl(mockWeatherApiClient)
    }

    @Test
    fun `should return true if min temp is less than 10`() {
        Mockito.`when`(mockWeatherApiClient.callToWeatherApi("birmingham")).thenReturn(TestFixtures.generateCoatNeededMinTempModel())
        val serviceResponse = dinacService.doINeedACoat("birmingham")
        val isCoatNeeded = serviceResponse.isCoatNeeded
        isCoatNeeded.shouldBeTrue();
    }

    @Test
    fun `should return true if precipitation is more than 0 point 4 mm`() {
        Mockito.`when`(mockWeatherApiClient.callToWeatherApi("birmingham")).thenReturn(TestFixtures.generateCoatNeededRainModel())
        val serviceResponse = dinacService.doINeedACoat("birmingham")
        val isCoatNeeded = serviceResponse.isCoatNeeded
        isCoatNeeded.shouldBeTrue();
    }

    @Test
    fun `should return false if min temp is greater than 10`() {
        Mockito.`when`(mockWeatherApiClient.callToWeatherApi("birmingham")).thenReturn(TestFixtures.generateCoatNotNeededModel())
        val serviceResponse = dinacService.doINeedACoat("birmingham")
        val isCoatNeeded = serviceResponse.isCoatNeeded
        isCoatNeeded.shouldBeFalse();
    }
}