import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val send = Stack<IntArray>()

    val num = br.readLine().toInt()
    val numbers = br.readLine().split(" ").map { it.toInt() }

    repeat(num) {
        val input = numbers[it]

        while(send.isNotEmpty()) {
            if(send.peek()[0] < input) {
                send.pop()
            } else {
                print("${send.peek()[1]} ")
                break
            }
        }

        if(send.isEmpty()) {
            print("0 ")
        }

        send.push(intArrayOf(input, it + 1))
    }
}