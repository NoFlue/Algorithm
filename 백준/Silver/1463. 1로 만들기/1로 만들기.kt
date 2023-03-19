import kotlin.math.min

fun main() {
    val input = readln().toInt()
    val dp = IntArray(1000001) { 0 }.apply {
        this[1] = 0
    }

    for(i in 2..input) {
        dp[i] = dp[i - 1] + 1 // 2와 3으로 나눠지지 않을 경우
        if(i % 2 == 0) {
            dp[i] = min(dp[i], dp[i / 2] + 1)
        }
        if(i % 3 == 0) {
            dp[i] = min(dp[i], dp[i / 3] + 1)
        }
    }

    println(dp[input])
}