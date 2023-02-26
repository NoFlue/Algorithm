import kotlin.math.max

val onSale = arrayOf(10, 20, 30, 40)
lateinit var isDecision: IntArray
var maxPlusUser = 0
var maxEmoticonProfit = 0

class Solution{
    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        isDecision = IntArray(emoticons.size) { 0 }

        getEmoticonProfit(users, emoticons, 0)

        return intArrayOf(maxPlusUser, maxEmoticonProfit)
    }

    fun getEmoticonProfit(users: Array<IntArray>, emoticons: IntArray, count: Int) {
        if(count == emoticons.size) {
            var plusUser = 0
            var emoticonProfit = 0

            for(user in users) {
                val (wantedSale, money) = user
                var buyEmoticons = 0
                for((index, sale) in isDecision.withIndex()) {
                    if(wantedSale <= sale) {
                        buyEmoticons += emoticons[index] * (100 - sale) / 100
                    }
                }
                if(buyEmoticons >= money) {
                    plusUser++
                } else {
                    emoticonProfit += buyEmoticons
                }
            }

            if(maxPlusUser <= plusUser) {
                maxEmoticonProfit = if(maxPlusUser == plusUser) max(maxEmoticonProfit, emoticonProfit) else emoticonProfit
                maxPlusUser = plusUser
            }
            return
        }

        repeat(4) {
            isDecision[count] = onSale[it]
            getEmoticonProfit(users, emoticons, count + 1)
        }
    }
}