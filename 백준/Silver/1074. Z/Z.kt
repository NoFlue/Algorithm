var answer = 0

fun main() {
    val (n, r, c) = readln().split(" ").map { it.toInt() }
    solve(r, c, n)
    
    println(answer)
}

fun solve(row: Int, column: Int, n: Int) {
    if(n == 0) return

    val newSize = 1 shl (n - 1)

    if(row < newSize && column < newSize) {
        solve(row, column, n - 1)
    } else if(row < newSize && column >= newSize) {
        answer += 1 shl (2 * (n - 1))
        solve(row, column - newSize, n - 1)
    } else if(row >= newSize && column < newSize) {
        answer += (1 shl (2 * (n - 1))) * 2
        solve(row - newSize, column, n - 1)
    } else {
        answer += (1 shl (2 * (n - 1))) * 3
        solve(row - newSize, column - newSize, n - 1)
    }
}