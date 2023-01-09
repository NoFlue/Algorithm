val stringBuilder = StringBuilder()
lateinit var arr: Array<IntArray>

fun main() {
    val input = readln().toInt()
    arr = Array(input) { IntArray(input) }
    repeat(input) {
        arr[it] = readln().map { it - '0' }.toIntArray()
    }

    solve(0, 0, input)

    println(stringBuilder.toString())
}

fun solve(row: Int, column: Int, size: Int) {
    if(check(row, column, size)) {
        when(arr[row][column]) {
            0 -> stringBuilder.append("0")
            1 -> stringBuilder.append("1")
        }
        return
    }

    val newSize = size / 2

    stringBuilder.append("(")
    for(i in row until row + size step newSize) {
        for(j in column until column + size step newSize) {
            solve(i, j, newSize)
        }
    }
    stringBuilder.append(")")
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