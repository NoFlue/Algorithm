import java.lang.Integer.max
import java.util.*

val dx = arrayOf(0, -1, 0, 1)
val dy = arrayOf(1, 0, -1, 0)

fun main() {
    val (column, row) = readln().split(" ").map { it.toInt() }
    val tomato = Array(row) { IntArray(column) }

    repeat(row) { row ->
        tomato[row] = readln().split(" ").map { it.toInt() }.toIntArray()
    }

    var day = 0
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    repeat(row) { row ->
        repeat(column) { column ->
            if(tomato[row][column] == 1) {
                queue.add(Pair(row, column))
            }
        }
    }

    while (queue.isNotEmpty()) {
        val pos = queue.poll()
        for(i in 0..3) {
            val nx = pos.first + dx[i]
            val ny = pos.second + dy[i]
            if(nx < 0 || nx >= row || ny < 0 || ny >= column) continue
            if(tomato[nx][ny] >= 1 || tomato[nx][ny] == -1) continue
            tomato[nx][ny] = tomato[pos.first][pos.second] + 1
            queue.add(Pair(nx, ny))
            day = max(day, tomato[nx][ny])
        }
    }

    for(i in 0 until row) {
        for(j in 0 until column) {
            if(tomato[i][j] == 0) {
                println("-1")
                return
            }
        }
    }

    println(if(day == 0) 0 else day - 1)
}