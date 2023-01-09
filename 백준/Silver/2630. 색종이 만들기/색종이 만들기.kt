lateinit var arr: Array<IntArray>
var white = 0
var blue = 0

fun main() {
    val input = readln().toInt()
    arr = Array(input) { IntArray(input) }
    repeat(input) {
        arr[it] = readln().split(" ").map { it.toInt() }.toIntArray()
    }

    solve(0, 0, input)

    println(white)
    println(blue)
}

fun solve(row: Int, column: Int, size: Int) {
    if(check(row, column, size)) {
        when(arr[row][column]) {
            0 -> white++
            1 -> blue++
        }
        return
    }

    val newSize = size / 2

    for(i in row until row + size step newSize) {
        for(j in column until column + size step newSize) {
            solve(i, j, newSize)
        }
    }
}

fun check(row: Int, column: Int, size: Int) : Boolean {
    for(i in row until size + row) {
        for(j in column until size + column) {
            if(arr[i][j] != arr[row][column]) {
                return false
            }
        }
    }
    return true
}