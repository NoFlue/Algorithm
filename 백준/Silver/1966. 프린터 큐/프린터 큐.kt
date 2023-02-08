import java.util.LinkedList
import java.util.Queue

fun main() {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    repeat(readln().toInt()) {
        val (size, index) = readln().split(" ").map { it.toInt() }
        queue.addAll(readln().split(" ").mapIndexed { index, s -> Pair(s.toInt(), index) })

        var count = 0
        while (true) {
            val peek = queue.poll()
            var isMax = true

            for(value in queue) {
                if(peek.first < value.first) {
                    isMax = false
                    break
                }
            }

            if(isMax) {
                count++
                if(peek.second == index) {
                    println(count)
                    break
                }
            } else {
                queue.add(peek)
            }
        }

        queue.clear()
    }
}