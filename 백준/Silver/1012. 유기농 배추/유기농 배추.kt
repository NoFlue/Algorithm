import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val dx = arrayOf(1, 0, -1, 0)
val dy = arrayOf(0, 1, 0, -1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    repeat(readLine().toInt()){
        val (width, height, count) = readLine().split(" ").map { it.toInt() }
        val field = Array(height) { BooleanArray(width) { false } }

        repeat(count) {
            val (x, y) = readLine().split(" ").map { it.toInt() }
            field[y][x] = true
        }

        val queue: Queue<Pair<Int, Int>> = LinkedList()
        var worm = 0

        for(row in field.indices) {
            for(column in field[0].indices) {
                if(field[row][column]) {
                    queue.add(Pair(row, column))
                    field[row][column] = false

                    while(queue.isNotEmpty()) {
                        val (y, x) = queue.poll()
                        for(i in 0 until 4) {
                            val nx = x + dx[i]
                            val ny = y + dy[i]

                            if(nx < 0 || nx >= width || ny < 0 || ny >= height) continue
                            if(!field[ny][nx]) continue

                            queue.add(Pair(ny, nx))
                            field[ny][nx] = false
                        }
                    }

                    worm++
                }
            }
        }

        println(worm)
    }

}