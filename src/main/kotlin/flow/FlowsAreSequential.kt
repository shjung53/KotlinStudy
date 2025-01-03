package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

/***
 * https://velog.io/@shjung53/kotlin-Flows-are-sequential
 */
fun main() = runBlocking {
    (1..5).asFlow()
        .map {
            println("Map $it")
            if (it % 2 == 0) delay(1000)
            "string $it"
        }.collect {
            println("Collect $it")
        }
}
