fun main() {
    val num = readln()
    var temp = 0L
    repeat(num.length) {
        temp = (temp * 10 + (num[it] - '0')) % 20000303
    }
    println(temp)
}