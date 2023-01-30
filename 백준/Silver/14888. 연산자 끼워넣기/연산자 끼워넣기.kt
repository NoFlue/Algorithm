import kotlin.math.max
import kotlin.math.min

lateinit var operator: IntArray
lateinit var operand: IntArray
var max = Integer.MIN_VALUE
var min = Integer.MAX_VALUE

fun main() {
    val count = readln().toInt()
    operand = readln().split(" ").map { it.toInt() }.toIntArray()
    operator = readln().split(" ").map { it.toInt() }.toIntArray()

    solve(count = count, result = 0)

    println("$max\n$min")
}

fun solve(currentCount: Int = 0, count: Int, result: Int) {
    if(currentCount == count - 1) {
        max = max(max, result)
        min = min(min, result)
        return
    }

    repeat(4) {
        if(operator[it] != 0) {
            --operator[it]
            val resultOperand = if(currentCount == 0) operand[currentCount] else result
            when(it) {
                0 -> solve(currentCount + 1, count, resultOperand + operand[currentCount + 1])
                1 -> solve(currentCount + 1, count, resultOperand - operand[currentCount + 1])
                2 -> solve(currentCount + 1, count, resultOperand * operand[currentCount + 1])
                else -> solve(currentCount + 1, count, resultOperand / operand[currentCount + 1])
            }
            ++operator[it]
        }
    }
}