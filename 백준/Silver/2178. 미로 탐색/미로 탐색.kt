import java.util.LinkedList
import java.util.Queue

val dx = arrayOf(1, 0, -1, 0)
val dy = arrayOf(0, 1, 0, -1)

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val maze = Array(n) { IntArray(m) }
    val visit = Array(n) { IntArray(m) { -1 } }

    repeat(n) {
        val input = readln().map { it.digitToInt() }.toIntArray()
        maze[it] = input
    }

    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(0,0))
    visit[0][0] = 0

    while (queue.isNotEmpty()) {
        val current = queue.remove()
        for(index in 0..3) {
            val nx = current.first + dx[index]
            val ny = current.second + dy[index]
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue
            if(maze[nx][ny] == 0 || visit[nx][ny] != -1) continue
            visit[nx][ny] = visit[current.first][current.second] + 1
            queue.add(Pair(nx, ny))
        }
    }

    println(visit[n - 1][m - 1] + 1)
}