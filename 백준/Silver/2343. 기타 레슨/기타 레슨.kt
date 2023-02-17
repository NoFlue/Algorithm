import kotlin.math.max
import kotlin.math.min

fun main() {
    val (lecture, bluray) = readln().split(" ").map { it.toInt() }
    val minute = readln().split(" ").map { it.toInt() }.toIntArray()

    var start = minute.max()
    var end = minute.sum()

    while (start <= end) {
        val mid = (start + end) / 2

        var size = 0
        var count = 0
        for(i in minute.indices) {
            if(size + minute[i] > mid) {
                count++
                size = 0
            }
            size += minute[i]
        }

        if(size != 0) count++

        if(count > bluray) start = mid + 1
        else end = mid - 1
    }

    println(start)
}