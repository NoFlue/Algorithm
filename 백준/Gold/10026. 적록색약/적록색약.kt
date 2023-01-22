import java.lang.Integer.max
import java.util.*

val dx = arrayOf(0, -1, 0, 1)
val dy = arrayOf(1, 0, -1, 0)

fun main() {
    val size = readln().toInt()
    val arr = Array(size) { CharArray(size) }
    repeat(size) {
        arr[it] = readln().toCharArray()
    }

    var colorArea = 0
    val colorQueue: Queue<Pair<Int, Int>> = LinkedList()
    var colorVisit = Array(size) { BooleanArray(size) { false } }

    for(row in 0 until size) {
        for(column in 0 until size) {
            if(!colorVisit[row][column]) {
                colorQueue.add(Pair(row, column))
                colorVisit[row][column] = true
                bfs(colorQueue, arr, colorVisit, size)
                colorArea++
            }
        }
    }

    print("$colorArea ")
    colorArea = 0
    colorVisit = Array(size) { BooleanArray(size) { false } }

    repeat(size) { row ->
        repeat(size) { column ->
            if(arr[row][column] == 'G') {
                arr[row][column] = 'R'
            }
        }
    }

    for(row in 0 until size) {
        for(column in 0 until size) {
            if(!colorVisit[row][column]) {
                colorQueue.add(Pair(row, column))
                colorVisit[row][column] = true
                bfs(colorQueue, arr, colorVisit, size)
                colorArea++
            }
        }
    }
    print(colorArea)
}

fun bfs(queue: Queue<Pair<Int, Int>>, area: Array<CharArray>, visit: Array<BooleanArray>, size: Int) {
    while(queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for(i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]
            if(nx < 0 || nx >= size || ny < 0 || ny >= size) continue
            if(area[nx][ny] != area[x][y] || visit[nx][ny]) continue
            queue.add(Pair(nx, ny))
            visit[nx][ny] = true
        }
    }
}