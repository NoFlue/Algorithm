import java.lang.Integer.max
import java.util.*

val dx = arrayOf(0, -1, 0, 1)
val dy = arrayOf(1, 0, -1, 0)
var safeZone = 0

fun main() {
    val (row, column) = readln().split(" ").map { it.toInt() }
    val field = Array(row) { IntArray(column) }

    repeat(row) {
        field[it] = readln().split(" ").map { it.toInt() }.toIntArray()
    }

    for(first in 0 until row * column) {
        val firstRow = first / column
        val firstColumn = first % column
        if(field[firstRow][firstColumn] == 1 || field[firstRow][firstColumn] == 2) continue
        field[firstRow][firstColumn] = 1

        for(second in first until row * column) {
            val secondRow = second / column
            val secondColumn = second % column
            if(field[secondRow][secondColumn] == 1 || field[secondRow][secondColumn] == 2) continue
            field[secondRow][secondColumn] = 1

            for(third in second until row * column) {
                val thirdRow = third / column
                val thirdColumn = third % column
                if(field[thirdRow][thirdColumn] == 1 || field[thirdRow][thirdColumn] == 2) continue
                field[thirdRow][thirdColumn] = 1

                bfs(field, row, column)

                field[thirdRow][thirdColumn] = 0
            }

            field[secondRow][secondColumn] = 0
        }

        field[firstRow][firstColumn] = 0
    }

    println(safeZone)
}

fun bfs(field: Array<IntArray>, row: Int, column: Int) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    val tempField = Array(row) { IntArray(column) }

    repeat(row) { row ->
        repeat(column) { column ->
            tempField[row][column] = field[row][column]
        }
    }

    repeat(row) { row ->
        repeat(column) { column ->
            if(tempField[row][column] == 2) {
                queue.add(Pair(row, column))
            }
        }
    }

    while(queue.isNotEmpty()) {
        val pos = queue.poll()
        for(i in 0..3) {
            val nx = pos.first + dx[i]
            val ny = pos.second + dy[i]
            if(nx < 0 || nx >= row || ny < 0 || ny >= column) continue
            if(tempField[nx][ny] == 1 || tempField[nx][ny] == 2) continue
            tempField[nx][ny] = 2
            queue.add(Pair(nx, ny))
        }
    }

    var tempSafeZone = 0
    repeat(row) { row ->
        repeat(column) { column ->
            if(tempField[row][column] == 0) {
                tempSafeZone++
            }
        }
    }

    safeZone = max(safeZone, tempSafeZone)
}