class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val answer = mutableListOf<Int>()
        val todayDate = today.split(".").map { it.toInt() }
        val termsInfo = Array(terms.size) { Pair("", "") }

        for ((index, term) in terms.withIndex()) {
            val (type, period) = term.split(" ")
            termsInfo[index] = Pair(type, period)
        }

        for ((index, privacy) in privacies.withIndex()) {
            val (date, type) = privacy.split(" ")

            val privacyDate = date.split(".").map { it.toInt() }
            var period = 0
            for (term in termsInfo) {
                if (type == term.first) {
                    period = term.second.toInt()
                    break
                }
            }

            var totalDays = 0
            totalDays += ((todayDate[0] - privacyDate[0]) * 336) + ((todayDate[1] - privacyDate[1]) * 28) + (todayDate[2] - privacyDate[2])

            if (totalDays >= period * 28) {
                answer += index + 1
            }
        }

        return answer.toIntArray()
    }
}       