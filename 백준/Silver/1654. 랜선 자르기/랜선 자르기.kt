fun main() {
    val (lan, count) = readln().split(" ").map { it.toInt() }
    val lanCable = IntArray(lan)

    repeat(lan) {
        lanCable[it] = readln().toInt()
    }

    var start = 0L
    var end = 2147483647L
    var maxLength = 0L

    while (start <= end) {
        val mid = (start + end) / 2

        if(determination(mid, count, lanCable)) {
            start = mid + 1
            maxLength = mid
        } else {
            end = mid - 1
        }
    }

    println(maxLength)
}

fun determination(length: Long, requireCount: Int, lanCable: IntArray): Boolean {
    var count = 0
    for(i in lanCable) {
        count += (i / length).toInt()
    }

    return count >= requireCount
}