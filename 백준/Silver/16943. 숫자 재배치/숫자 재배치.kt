import kotlin.math.max

lateinit var arr: IntArray
lateinit var isUsed: BooleanArray
var maximum = -1

fun main() {
    val (a, b) = readln().split(" ")
    arr = IntArray(a.length) { a[it].digitToInt() }
    isUsed = BooleanArray(a.length) { false }

    find(0, a.length, b.toInt(), 0)

    println(maximum)
}

fun find(count: Int, length: Int, target: Int, current: Int) {
    if(count == length) {
        if(current < target) {
            maximum = max(maximum, current)
        }
    }

    if(count >= 1 && current == 0) return

    for(i in 0 until length) {
        if(isUsed[i] || current >= target) continue

        isUsed[i] = true
        find(count + 1, length, target, current * 10 + arr[i])
        isUsed[i] = false
    }
}