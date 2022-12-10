lateinit var arr: LongArray

fun main() {
    val n = readln().toInt()
    arr = LongArray(n + 1, { -1L }).apply {
        this[0] = 0
        this[1] = 1
    }

    println(fibonacci(n))
}

fun fibonacci( n: Int): Long {
    if(arr[n] == -1L) {
        arr[n] = fibonacci(n - 1) + fibonacci(n - 2)
    }
    return arr[n]
}