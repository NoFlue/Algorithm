import kotlin.math.max

fun main() {
    val input = readln().toInt()
    val arr = IntArray(input + 1)
    val dp = IntArray(input + 1).apply {this[0] = 0}

    repeat(input) {
        arr[it + 1] = readln().toInt()
    }

    if(input == 1) {
        print(arr[1])
    }  else if(input == 2) {
        print(arr[1] + arr[2])
    } else {
        dp[1] = arr[1]
        dp[2] = arr[1] + arr[2]

        for(i in 3..input) {
            dp[i] = max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i])
        }

        print(dp[input])
    }
}