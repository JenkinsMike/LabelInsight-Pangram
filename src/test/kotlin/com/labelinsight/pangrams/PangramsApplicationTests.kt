package com.labelinsight.pangrams

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class PangramsApplicationTests {
	@Autowired var pangram: Pangram? = null

	@BeforeEach
	fun setup() {
		pangram = Pangram(alphabet = CharRange('a', 'z').asIterable().toSet())
	}

	@AfterEach
	fun tearDown() {
		pangram = null
	}

	@Test
	fun `The Quick Brown Fox Test`() {
		val inputOne = "A quick brown fox jumps over the lazy dog"
		val expectedOne = ""

		assertEquals(
			expectedOne, pangram!!.getMissingLetters(inputOne)
		)
	}

	@Test
	fun `The Yellow Fox Test`() {
		val inputTwo = "A slow yellow fox crawls under the proactive dog"
		val expectedTwo = "bjkmqz"

		assertEquals(
			expectedTwo, pangram!!.getMissingLetters(inputTwo)
		)
	}

	@Test
	fun `The Quick Wizard of Oz Test`() {
		val inputThree = "Lions, and tigers, and bears, oh my!"
		val expectedThree = "cfjkpquvwxz"

		assertEquals(
			expectedThree, pangram!!.getMissingLetters(inputThree)
		)
	}

	@Test
	fun `The Whole Alphabet Test`() {
		val inputFour = ""
		val expectedFour = "abcdefghijklmnopqrstuvwxyz"

		assertEquals(
			expectedFour, pangram!!.getMissingLetters(inputFour)
		)
	}

	@Test
	fun `The Extras Test`() {
		val inputFive = "abcdefghijklmnopqrstuvwxy1234567890!@#$%^&*()"
		val expectedFive = "z"

		assertEquals(
			expectedFive, pangram!!.getMissingLetters(inputFive)
		)
	}
}
