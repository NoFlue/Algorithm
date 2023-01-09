lateinit var arr: Array<IntArray>

fun main() {
    val input = readln().toInt()
    arr = Array(input) { IntArray(input) }
    repeat(input) {
        arr[it] = readln().split(" ").map { it.toInt() }.toIntArray()
    }

    println(solve(0, 0, input))
}

fun solve(row: Int, column: Int, size: Int): Int {
    val temp = IntArray(4)

    if(size == 2) {
        var index = 0
        for(i in row..row + 1) {
            for (j in column..column + 1) {
                temp[index++] = arr[i][j]
            }
        }

        return temp.sorted().get(2)
    } else {
        val newSize = size / 2

        temp[0] = solve(row, column, newSize)
        temp[1] = solve(row, column + newSize, newSize)
        temp[2] = solve(row + newSize, column, newSize)
        temp[3] = solve(row + newSize, column + newSize, newSize)

        return temp.sorted().get(2)
    }
}