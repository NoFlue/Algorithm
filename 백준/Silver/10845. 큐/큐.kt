import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val queue: Queue<Int> = LinkedList()
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stringBuilder = StringBuilder()

    repeat(br.readLine().toInt()) {
        val command = br.readLine().split(" ")
        when(command[0]) {
            "push" -> queue.add(command[1].toInt())
            "pop" -> stringBuilder.appendLine(if(queue.isEmpty()) - 1 else queue.poll())
            "size" -> stringBuilder.appendLine(queue.size)
            "empty" -> stringBuilder.appendLine(if(queue.isEmpty()) 1 else 0)
            "front" -> stringBuilder.appendLine(if(queue.isEmpty()) -1 else queue.first())
            else -> stringBuilder.appendLine(if(queue.isEmpty()) -1 else queue.last())
        }
    }

    println(stringBuilder)
}