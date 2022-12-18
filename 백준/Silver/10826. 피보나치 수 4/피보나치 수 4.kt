import java.math.BigInteger

fun main() {
    val input = readln().toInt()

    if(input == 0) {
        print("0")
    } else if (input == 1) {
        print("1")
    } else {
        val dp = Array<BigInteger>(input + 1, { BigInteger.ZERO })
        dp[1] = BigInteger.ONE

        for(i in 2..input) {
            dp[i] = dp[i - 2].add(dp[i - 1])
        }

        print(dp[input])
    }
}