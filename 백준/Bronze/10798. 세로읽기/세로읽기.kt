fun main() {
    val text = Array(5) { CharArray(15) { ' ' } }

    repeat(5) {column ->
        val input = readln().trim().toCharArray().forEachIndexed { row, c ->
            text[column][row] = c
        }
    }

    for(row in 0..14) {
        for(column in 0..4) {
            if(text[column][row] == ' ') continue
            print(text[column][row])
        }
    }
}