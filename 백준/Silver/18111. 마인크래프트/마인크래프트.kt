import kotlin.math.max
import kotlin.math.min

fun main() {
    val (row, column, block) = readln().split(" ").map{ it.toInt() }
    val ground = Array(row) { IntArray(column) }
    var min = 256
    var max = 0
    repeat(row) { row ->
        ground[row] = readln().split(" ").map { it.toInt() }.toIntArray()
        repeat(column) { height ->
            min = min(min, ground[row][height])
            max = max(max, ground[row][height])
        }
    }

    var minTime = Integer.MAX_VALUE
    var maxHeight = min

    for(case in min..max) {
        var breakBlock = 0
        var placeBlock = 0
        var hasBlock = block
        for(row in 0 until row) {
            for(column in 0 until column) {
                if(ground[row][column] >= case) {
                    breakBlock += ground[row][column] - case
                    hasBlock += ground[row][column] - case
                } else {
                    placeBlock += case - ground[row][column]
                    hasBlock -= case - ground[row][column]
                }
            }
        }

        if(hasBlock < 0) continue

        val time = breakBlock * 2 + placeBlock
        if(time <= minTime && case >= maxHeight) {
            minTime = time
            maxHeight = case
        }
    }

    println("$minTime $maxHeight")
}