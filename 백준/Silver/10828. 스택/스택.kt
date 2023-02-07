import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val stack = Stack<Int>()
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stringBuilder = StringBuilder()

    repeat(br.readLine().toInt()) {
        val command = br.readLine().split(" ")
        when(command[0]) {
            "push" -> stack.add(command[1].toInt())
            "pop" -> stringBuilder.appendLine(if(stack.isEmpty()) -1 else stack.pop())
            "size" -> stringBuilder.appendLine(stack.size)
            "empty" -> stringBuilder.appendLine(if(stack.isEmpty()) 1 else 0)
            else -> stringBuilder.appendLine(if(stack.isEmpty()) -1 else stack.peek())
        }
    }

    println(stringBuilder)
}