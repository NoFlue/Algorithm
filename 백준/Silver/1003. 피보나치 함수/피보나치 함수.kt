fun main() {
    repeat(readln().toInt()) {
        val num = readln().toInt()
        val dp = Array(num + 1, { Pair(0, 0) }).apply {
            this[0] = Pair(1, 0)
            if(this.size > 1) this[1] = Pair(0, 1)
        }

        when(dp.size) {
            1 -> println("1 0")
            2 -> println("0 1")
            else -> {
                for(i in 2..num) {
                    dp[i] = Pair(dp[i - 2].first + dp[i - 1].first, dp[i - 2].second + dp[i - 1].second)
                }
                println("${dp[num].first} ${dp[num].second}")
            }
        }
    }
}