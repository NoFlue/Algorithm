import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val time = br.readLine().toInt()

    case@ for (i in 0 until time) {
        var forward = true
        val deque = LinkedList<Int>()
        val command = br.readLine()
        br.readLine().toInt() // 배열 크기 입력
        br.readLine().run {
            substring(1 until this.length - 1).split(",").filter { it.isNotBlank() }.map { it.toInt() }
                .forEach { deque.add(it) }
        } // 덱에 배열 값 저장

        for (cmd in command) {
            when (cmd) {
                'R' -> forward = !forward
                else -> {
                    if (deque.isEmpty()) {
                        println("error")
                        continue@case
                    }

                    if (forward) deque.removeFirst() else deque.removeLast()
                }
            }
        }

        println(if (forward) "[${deque.joinToString(",")}]" else "[${deque.reversed().joinToString(",")}]")
    }
}
