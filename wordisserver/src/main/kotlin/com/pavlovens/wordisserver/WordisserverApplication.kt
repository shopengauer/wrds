package com.pavlovens.wordisserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WordisserverApplication

fun main(args: Array<String>) {
    runApplication<WordisserverApplication>(*args)
}
