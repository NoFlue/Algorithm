var minus = 0
var zero = 0
var one = 0
lateinit var paper: Array<IntArray>

fun main() {
    val input = readln().toInt()
    paper = Array(input) {
        IntArray(input)
    }

    repeat(input) {
        val arr = readln().split(" ").map { it.toInt() }.toIntArray()
        paper[it] = arr
    }

    solve(0, 0, input)

    println(minus)
    println(zero)
    println(one)

}

fun solve(row: Int, column: Int, size: Int) {
    if(check(row, column, size)) {
        when(paper[row][column]) {
            -1 -> minus++
            0 -> zero++
            1 -> one++
        }
        return
    }

    val newSize = size / 3
    for(i in row until size + row step newSize) {
        for(j in column until size + column step newSize) {
            solve(i, j, newSize)
        }
    }
}

fun check(row: Int, column: Int, size: Int) : Boolean {
    for(i in row until size + row) {
        for(j in column until size + column) {
            if(paper[row][column] != paper[i][j]) {
                return false
            }
        }
    }
    return true
}