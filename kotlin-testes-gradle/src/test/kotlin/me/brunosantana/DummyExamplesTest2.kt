package me.brunosantana

import io.kotest.assertions.throwables.shouldNotThrowExactly
import io.kotest.assertions.throwables.shouldThrowExactly
import io.mockk.junit5.MockKExtension
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

}