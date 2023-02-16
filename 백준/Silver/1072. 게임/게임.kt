fun main() = with(System.`in`.bufferedReader()) {
    val (x, y) = readln().split(" ").map { it.toLong() }

    val z = 100 * y / x

    if (z >= 99L) {
        println(-1)
        return
    }

    var left = 0L
    var right = x

    while (left <= right) {
        val mid = (left + right) / 2
        val perc = ((mid + y) * 100) / (x + mid)

        if (perc != z) right = mid - 1
        else left = mid + 1
    }

    println(left)
}