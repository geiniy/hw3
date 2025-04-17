package org.example

import org.jetbrains.kotlinx.lincheck.annotations.Operation
import org.jetbrains.kotlinx.lincheck.check
import org.jetbrains.kotlinx.lincheck.strategy.managed.modelchecking.ModelCheckingOptions
import org.jetbrains.kotlinx.lincheck.strategy.stress.StressOptions
import org.junit.jupiter.api.Test

class TreiberStackTestStress {
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
        StressOptions().check(TreiberStackTestStress::class)
    }
}

class TreiberStackTestModelOptions {
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
        ModelCheckingOptions().check(TreiberStackTestModelOptions::class)
    }
}
