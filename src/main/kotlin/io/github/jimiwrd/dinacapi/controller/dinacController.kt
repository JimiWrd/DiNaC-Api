package io.github.jimiwrd.dinacapi.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class dinacController {

    @GetMapping
    fun doINeedACoat(): ResponseEntity<String> {
        return ResponseEntity.ok("Success");
    }
}