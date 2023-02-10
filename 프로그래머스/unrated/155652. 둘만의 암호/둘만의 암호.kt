class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        val stringBuilder = StringBuilder()

        for(c in s) {
            var char = c
            var count = 0

            while (count < index) {
                count++
                char = 'a' + (char - 'a' + 1) % 26
                if(char in skip) count--
            }

            stringBuilder.append(char)
        }

        return stringBuilder.toString()
    }
}