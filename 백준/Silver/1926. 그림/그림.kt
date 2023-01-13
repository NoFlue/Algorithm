import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

val dx = arrayOf(1, 0, -1, 0)
val dy = arrayOf(0, 1, 0, -1)

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val picture = Array(n) { IntArray(m) }
    val visit = Array(n) { BooleanArray(m) { false } }

    repeat(n) {
        val input = readln().split(" ").map { it.toInt() }.toIntArray()
        picture[it] = input
    }

    var count = 0
    var maxArea = 0
    for(i in 0 until n) {
        for(j in 0 until m) {
            if(picture[i][j] == 0 || visit[i][j]) continue
            count++
            val queue: Queue<Pair<Int, Int>> = LinkedList()
            var area = 0
            visit[i][j] = true
            queue.add(Pair(i, j))
            while(!queue.isEmpty()) {
                area++
                val current = queue.remove()
                for(index in 0..3) {
                    val nx = current.first + dx[index]
                    val ny = current.second + dy[index]
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue
                    if(picture[nx][ny] == 0 || visit[nx][ny]) continue
                    visit[nx][ny] = true
                    queue.add(Pair(nx, ny))
                }
            }
            maxArea = max(maxArea, area)
        }
    }

    println("$count\n$maxArea")
}