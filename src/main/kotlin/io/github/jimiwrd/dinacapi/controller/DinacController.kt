package io.github.jimiwrd.dinacapi.controller

import io.github.jimiwrd.dinacapi.dto.DinacResponseDto
import io.github.jimiwrd.dinacapi.service.DinacService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpStatusCodeException

@RestController
class DinacController @Autowired constructor(private val dinacService: DinacService){

    @GetMapping("/dinac")
    fun getDinacStatus(@RequestParam location: String): ResponseEntity<DinacResponseDto> {
        return try {
            val response = dinacService.doINeedACoat(location)
            ResponseEntity.ok(response);
        } catch (httpException: HttpStatusCodeException) {
            println(httpException.message)
            ResponseEntity(DinacResponseDto(false, "An unknown error occurred"), HttpStatus.BAD_REQUEST)
        }
    }
}