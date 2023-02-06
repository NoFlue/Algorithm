import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Deque
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val deque: Deque<Int> = LinkedList()

    repeat(br.readLine().toInt()) {
        val command = br.readLine().split(" ")

        when(command[0]) {
            "push_back" -> deque.addLast(command[1].toInt())
            "push_front" -> deque.addFirst(command[1].toInt())
            "front" -> bw.write("${if(deque.isEmpty()) -1 else deque.first}\n")
            "back" -> bw.write("${if(deque.isEmpty()) -1 else deque.last}\n")
            "size" -> bw.write("${deque.size}\n")
            "empty" -> bw.write("${if(deque.isEmpty()) 1 else 0}\n")
            "pop_front" -> bw.write("${if(deque.isEmpty()) -1 else deque.pollFirst()}\n")
            else -> bw.write("${if(deque.isEmpty()) -1 else deque.pollLast()}\n")
        }
    }

    bw.flush()
}