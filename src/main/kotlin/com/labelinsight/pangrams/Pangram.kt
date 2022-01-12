package com.labelinsight.pangrams

import java.util.*
import java.util.Locale.getDefault


open class Pangram(
    private val alphabet: Set<Char> = CharRange('a', 'z').asIterable().toSet()
) {
    fun getMissingLetters(input: String): String {
        var inputString = input
        var charChecker = 'a'

        val missingLetters = StringBuilder()

        inputString = inputString
            .replace(
                "[^a-zA-Z]".toRegex(), ""
            ).lowercase(
                getDefault()
            )

        if (inputString.isEmpty()) return alphabet.joinToString("")

        while (charChecker <= 'z') {
            if ((inputString.lowercase(getDefault()).indexOf(charChecker) < 0)
                && (inputString.lowercase(getDefault()).indexOf((charChecker.code + 32).toChar()) < 0)
            ) {
                missingLetters.append(charChecker)
            }

            charChecker++
        }

        return missingLetters.toString()
    }

    companion object {
        /**
         * I probably should have asked how the program was to execute.
         * Since I didn't, I am writing it two ways.
         *
         * In PangramsApplicatoin.kt, it will launch as a SpringBoot Application,
         * read one line, typed, and execute.
         *
         * In Pangram.kt's companion object, it will read until prompted to quit per the prompts.
         */
        @JvmStatic
        fun main(args: Array<String>) {
            val continuousScan = Scanner(System.`in`)
            println("Please enter a string and push Enter.")
            println("After pushing enter, this application will return all letters missing from the alphabet.")
            println("If no letters are missing, you will recieve an empty string.")
            println("Typing \"quit\" will quit, after telling you the missing letters.")

            while (true) {
                var inputLine = ""

                if (continuousScan.hasNextLine()) {
                    inputLine = continuousScan.nextLine()
                }

                if (inputLine.isNotEmpty()) {
                    println(Pangram().getMissingLetters(inputLine))
                    if (inputLine.equals("quit", true).not())
                        println("\nLet's do another one!")
                }

                if (inputLine.equals("quit", true)) {
                    println("Bye")
                    break
                }
            }
        }
    }
}
