import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val size = br.readLine().toInt()
    val board = Array(size){ BooleanArray(size) { false } } // 사과
    val turn = IntArray(size * size + 1) { 0 }  // 1 : Left, 2 : Right
    repeat(br.readLine().toInt()) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        board[y - 1][x - 1] = true
    }

    repeat(br.readLine().toInt()) {
        val (time, dir) = br.readLine().split(" ")
        turn[time.toInt()] = if(dir == "L") 1 else 2
    }

    var time = 0
    var dir = 1 // 1 : East , 2 : South , 3 : West , 4 : North
    val snake = LinkedList<Pair<Int, Int>>()
    snake.add(Pair(0, 0))


    game@ while(true) {
        var (x, y) = snake.first
        val (rx, ry) = snake.last

        time++

        when(dir) {
            1 -> ++x
            2 -> --y
            3 -> --x
            else -> ++y
        }

        if(!(x in 0 until size && y in 0 until size)) break

        snake.addFirst(Pair(x, y))

        for(i in 3 until snake.size) {
            val (sx, sy) = snake[i]
            if(sx == x && sy == y) break@game
        }

        if(board[x][y]) {
            board[x][y] = false
        } else {
            snake.removeLast()
        }

        if(turn[time] != 0) {
            if(turn[time] == 1) dir = if(dir + 1 > 4) 1 else dir + 1
            else dir = if(dir - 1 < 1) 4 else dir - 1
        }
    }

    println(time)
}