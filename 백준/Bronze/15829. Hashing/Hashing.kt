private infix fun Int.pow(other: Int): Int {
    if (other == 0) return 1

    var value = this
    repeat(other - 1) {
        value *= this
    }
    return value
}

fun main() {
    readln()
    var result = 0
    for((index, i) in readln().withIndex()) {
        val value = i - 'a' + 1
        result += value * (31 pow (index))
    }

    println(result % 1234567891)
}