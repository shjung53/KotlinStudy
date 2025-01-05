package flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun main() = runBlocking {
    simple().collect { value -> log("Collected $value") }
}

private fun simple(): Flow<Int> = flow {
    withContext(Dispatchers.Default) {}
    for (i in 1..3) {
        Thread.sleep(100) // cpu 자원을 사용하는 척
        log("Emitting $i")
        emit(i)
    }
}.flowOn(Dispatchers.Default)
