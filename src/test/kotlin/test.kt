package org.example

import org.jetbrains.kotlinx.lincheck.annotations.Operation
import org.jetbrains.kotlinx.lincheck.check
import org.jetbrains.kotlinx.lincheck.strategy.stress.StressOptions
import org.junit.jupiter.api.Test

class TreiberStackTest {
    private val stack = TreiberStack<Int>()

    @Operation
    fun push(x: Int) {
        stack.push(x)
    }

    @Operation
    fun pop(): Int? {
        return stack.pop()
    }

    @Test
    fun test() {
        StressOptions().check(TreiberStackTest::class)
    }
}

class TreiberStackTest2 {
    private val stack = TreiberStack<Int>()

    @Operation
    fun push(x: Int) {
        stack.push(x)
    }

    @Operation
    fun pop(): Int? {
        return stack.pop()
    }

    @Test
    fun test() {
        StressOptions().threads(2).check(TreiberStackTest2::class)
    }
}