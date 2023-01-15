fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }
    val board = Array(a) { CharArray(b) }

    repeat(a) {
        board[it] = readln().toCharArray()
    }

    var min = a * b / 2

    for(i in 0 until a - 7) {
        for(j in 0 until b - 7) {
            var white = 0
            var black = 0
            for(row in i until i + 8) {
                for(column in j until j + 8) {
                    if((row + column) % 2 == 0) {
                        if(board[row][column] == 'B') {
                            white++
                        } else {
                            black++
                        }
                    } else {
                        if(board[row][column] == 'B') {
                            black++
                        } else {
                            white++
                        }
                    }
                }
            }
            min = minOf(min, white, black)
        }
    }
    println(min)
}