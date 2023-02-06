private infix fun Long.pow(other: Int): Long {
    var result = this
    repeat(other - 1) {
        result *= this
    }

    return result
}

fun main() {
    while (true) {
        val (a, b, c) = readln().split(" ").map { it.toLong() pow 2 }.sorted()
        if(a == 0L || b == 0L || c == 0L) break

        val isRight = (a + b) == c
        println(if(isRight) "right" else "wrong")
    }
}