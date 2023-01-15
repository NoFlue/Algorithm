import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() {
    val stringBuilder = StringBuilder()
    BufferedReader(InputStreamReader(System.`in`)).use { reader ->
        val input = reader.readLine().toInt()
        val stack = Stack<Int>()

        var pushNum = 1
        repeat(input) {
            val num = reader.readLine().toInt()
            while(pushNum <= num) {
                stack.push(pushNum)
                pushNum++
                stringBuilder.append("+\n")
            }

            if(stack.peek() == num) {
                stack.pop()
                stringBuilder.append("-\n")
            } else {
                println("NO")
                return
            }
        }
    }
    println(stringBuilder)
}