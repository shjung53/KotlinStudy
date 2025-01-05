package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

private fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100) // pretend we are asynchronously waiting 100 ms
        emit(i) // emit next value
    }
}

fun main() = runBlocking<Unit> {
//    val time = measureTimeMillis {
//        simple()
//            .buffer() // buffer emissions, don't wait
//            .collect { value ->
//                log("Collected $value")
//                delay(300) // pretend we are processing it for 300 ms
//                println(value)
//            }
//    }

//    val time = measureTimeMillis {
//        simple()
//            .conflate() // conflate emissions, don't process each one
//            .collect { value ->
//                delay(300) // pretend we are processing it for 300 ms
//                println(value)
//            }
//    }

    val time = measureTimeMillis {
        simple()
            .collectLatest { value -> // cancel & restart on the latest value
                println("Collecting $value")
                delay(300) // pretend we are processing it for 300 ms
                println("Done $value")
            }
    }

    println("Collected in $time ms")
}
