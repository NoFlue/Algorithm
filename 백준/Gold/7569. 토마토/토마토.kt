import java.lang.Integer.max
import java.util.*

val dx = arrayOf(0, -1, 0, 1, 0, 0)
val dy = arrayOf(1, 0, -1, 0, 0, 0)
val dz = arrayOf(0, 0, 0, 0, 1, -1)

fun main() {
    val (column, row, height) = readln().split(" ").map { it.toInt() }
    val tomato = Array(height) { Array(row) { IntArray(column) } }

    repeat(height) { height ->
        repeat(row) { row ->
            tomato[height][row] = readln().split(" ").map { it.toInt() }.toIntArray()
        }
    }


    var day = 0
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()

    repeat(height) { height ->
        repeat(row) { row ->
            repeat(column) { column ->
                if(tomato[height][row][column] == 1) {
                    queue.add(Triple(row, column, height))
                }
            }
        }
    }

    while (queue.isNotEmpty()) {
        val pos = queue.poll()
        for(i in 0..5) {
            val nx = pos.first + dx[i]
            val ny = pos.second + dy[i]
            val nz = pos.third + dz[i]
            if(nx < 0 || nx >= row || ny < 0 || ny >= column || nz < 0 || nz >= height) continue
            if(tomato[nz][nx][ny] >= 1 || tomato[nz][nx][ny] == -1) continue
            tomato[nz][nx][ny] = tomato[pos.third][pos.first][pos.second] + 1
            queue.add(Triple(nx, ny, nz))
            day = max(day, tomato[nz][nx][ny])
        }
    }

    for(h in 0 until height) {
        for(i in 0 until row) {
            for(j in 0 until column) {
                if(tomato[h][i][j] == 0) {
                    println("-1")
                    return
                }
            }
        }
    }

    println(if(day == 0) 0 else day - 1)
}