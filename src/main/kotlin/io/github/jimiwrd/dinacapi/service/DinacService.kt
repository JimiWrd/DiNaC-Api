package io.github.jimiwrd.dinacapi.service

import io.github.jimiwrd.dinacapi.dto.DinacResponseDto

interface DinacService {
    fun doINeedACoat(location: String): DinacResponseDto
}