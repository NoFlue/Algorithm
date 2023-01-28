import kotlin.math.max

val dx = arrayOf(0, 1, 0, -1)
val dy = arrayOf(1, 0, -1, 0)
lateinit var arr: Array<IntArray>
val isVisit = BooleanArray(26) { false }
var max = 0

fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    arr = Array(r) { IntArray(c) }
    repeat(r) {
        arr[it] = readln().toCharArray().map { it - 'A' }.toIntArray()
    }

    dfs(0, 0, 0, r, c)
    println(max)
}

fun dfs(move: Int, row: Int, column: Int, r: Int, c: Int) {
    if(isVisit[arr[row][column]]) {
        max = max(max, move)
        return
    }
    isVisit[arr[row][column]] = true
    for(it in 0 until 4) {
        val nx = row + dx[it]
        val ny = column + dy[it]

        if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue
        dfs(move + 1, nx, ny, r, c)
    }
    isVisit[arr[row][column]] = false
}