package me.brunosantana

import io.kotest.assertions.throwables.shouldNotThrowExactly
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class DummyExamplesTest2 {

    @Test
    fun `test which cannot throw exception`() {
        shouldNotThrowExactly<RuntimeException> { doSomething() }
    }

    @Test
    fun `test which expects an exception`() {
         shouldThrowExactly<RuntimeException> { doSomethingThatThrowsException() }
    }

    @Test
    fun `example using mockk and returnsMany`(){
        val dummyExamples: DummyExamples = mockk()
        every { dummyExamples.getText() } returnsMany ( listOf("fake text", "fake text 2") )

        val t1 = dummyExamples.getText()
        val t2 = dummyExamples.getText()

        println(t1)
        println(t2)

        t1 shouldBe "fake text"
        t2 shouldBe "fake text 2"
    }

}