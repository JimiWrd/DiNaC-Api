package io.github.jimiwrd.dinacapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DinacApiApplication

fun main(args: Array<String>) {
	runApplication<DinacApiApplication>(*args)
}
