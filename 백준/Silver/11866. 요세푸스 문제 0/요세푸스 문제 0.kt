import java.util.Deque
import java.util.LinkedList

fun main() {
    val deque: Deque<Int> = LinkedList()
    val (n, k) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(n)
    deque.addAll((1..n).toList())

    var count = 0

    while (deque.isNotEmpty()) {
        repeat(k - 1) {
            val num = deque.pollFirst()
            deque.addLast(num)
        }

        arr[count] = deque.pollFirst()
        count++
    }

    println(arr.joinToString(prefix = "<", postfix = ">"))
}