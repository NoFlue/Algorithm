import java.util.*

val dx = arrayOf(0, 1, 0, -1)
val dy = arrayOf(1, 0, -1, 0)

fun main() {
    val (m, n, count) = readln().split(" ").map { it.toInt() }
    val arr = Array(m) { BooleanArray(n) { false } }

    repeat(count) {
        val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }
        for(row in y1 until y2) {
            for(column in x1 until x2) {
                arr[row][column] = true
            }
        }
    }

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val sizeList = mutableListOf<Int>()

    for(row in 0 until m) {
        for(column in 0 until n) {
            if(arr[row][column]) continue

            var size = 1
            queue.add(Pair(row, column))
            arr[row][column] = true

            while (queue.isNotEmpty()) {
                val pos = queue.poll()
                for(i in 0 until 4) {
                    val ny = pos.first + dy[i]
                    val nx = pos.second + dx[i]
                    if(ny < 0 || ny >= m || nx < 0 || nx >= n) continue
                    if(arr[ny][nx]) continue

                    queue.add(Pair(ny, nx))
                    arr[ny][nx] = true
                    size++
                }
            }
            sizeList.add(size)
        }
    }

    println(sizeList.size)
    sizeList.sorted().forEach { print("$it ") }
}