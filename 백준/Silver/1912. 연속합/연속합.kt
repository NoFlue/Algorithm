import java.lang.Integer.max

fun main() {
    val input = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.toIntArray()
    val dp = IntArray(input)

    var sum = arr[0]
    dp[0] = arr[0]

    for(i in 1 until input) {
        dp[i] = max(dp[i - 1] + arr[i] , arr[i])
        sum = max(dp[i], sum)
    }

    print(sum)
}