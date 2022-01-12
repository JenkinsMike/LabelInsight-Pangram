package com.labelinsight.pangrams

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import java.util.*


@SpringBootApplication(
    exclude = [DataSourceAutoConfiguration::class]
)
class PangramsApplication

/**
 * I probably should have asked how the program was to execute.
 * Since I didn't, I am writing it two ways.
 *
 * In PangramsApplicatoin.kt, it will launch as a SpringBoot Application,
 * read one line, typed, and execute.
 *
 * In Pangram.kt's companion object, it will read until prompted to quit per the prompts.
 */
fun main(args: Array<String>) {
    runApplication<PangramsApplication>(*args)

    val inputScanner = Scanner(System.`in`)
    var inputLine = ""

    if (inputScanner.hasNextLine()) {
        inputLine = inputScanner.nextLine()
    }

    inputScanner.close()

    if (inputLine.isNotEmpty()) {
        println(Pangram().getMissingLetters(inputLine))
    }
}
