import java.util.LinkedList
import java.util.Queue

fun main() {
    val num = readln().toInt()
    val queue: Queue<Int> = LinkedList<Int>().apply {
        this.addAll((1..num).toList())
    }

    while(queue.size != 1) {
        queue.poll()
        val head = queue.poll()
        queue.add(head)
    }

    println(queue.peek())
}