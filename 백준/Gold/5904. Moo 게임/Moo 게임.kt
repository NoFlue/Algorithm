val defaultMoo = "moo"

fun main() {
    val input = readln().toInt()

    println(moo(input, 1, 3))
}

fun moo(n: Int, k: Int, len: Int) : Char {
    val newLen = len * 2 + (k + 3)

    if(n <= 3) {
        return defaultMoo[n - 1]
    }
    if(newLen < n) {
        return moo(n, k + 1, newLen)
    }
    if(n > len && n <= len + k + 3) {
        return if(n - len != 1) 'o' else 'm'
    }
    return moo(n - (len + k + 3), 1, 3)
}