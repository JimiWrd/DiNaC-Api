package io.github.jimiwrd.dinacapi.controller

import io.github.jimiwrd.dinacapi.service.dinacService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class dinacController @Autowired constructor(private val dinacService: dinacService){

    @GetMapping("/dinac")
    fun getDinacStatus(@RequestParam location: String): ResponseEntity<String> {
        dinacService.doINeedACoat(location)
        return ResponseEntity.ok("Success");
    }
}