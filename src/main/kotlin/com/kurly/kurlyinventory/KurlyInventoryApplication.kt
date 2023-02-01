package com.kurly.kurlyinventory

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KurlyInventoryApplication

fun main(args: Array<String>) {
    runApplication<KurlyInventoryApplication>(*args)
}
