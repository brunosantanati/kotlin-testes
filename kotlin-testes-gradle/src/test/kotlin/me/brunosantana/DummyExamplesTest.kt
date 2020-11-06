package me.brunosantana

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import java.lang.RuntimeException

//DOC Functional (SAM) interfaces: https://kotlinlang.org/docs/reference/fun-interfaces.html
class DummyExamplesTest {

    @Test
    fun `test which cannot throw exception`() {
        //assertDoesNotThrow(Executable { doSomething() })
        //assertDoesNotThrow({ doSomething() })
        assertDoesNotThrow { doSomething() }
    }

    @Test
    fun `test which expects an exception`() {
        assertThrows(RuntimeException::class.java, Executable { doSomethingThatThrowsException() })
    }

}