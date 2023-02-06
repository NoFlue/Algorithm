fun factorial(num: Int): Int {
    if(num == 0) return 1
    return num * factorial(num - 1)
}

fun main() {
    val (n, r) = readln().split(" ").map { it.toInt() }

    println("${factorial(n) / ( factorial(n - r) * factorial(r))}")
}