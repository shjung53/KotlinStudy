package flow

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking


fun main(): Unit = runBlocking {
    val list = (1..5)

    val sum = list.asFlow()
        .map { it * it } // squares of numbers from 1 to 5
        .reduce { a, b -> a + b } // sum them (terminal operator)
    println(sum)

    val sum2 = list.asFlow().fold(0) { a, b -> a + b }
    println(sum2)

    val first = list.asFlow().first { it ->
        it == 2
    }
    println(first)

    val single = list.asFlow().singleOrNull()
    println(single)
}
