import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val stack = Stack<Int>()
    val count = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val printArr = IntArray(count)

    for(i in count - 1 downTo 0) {
        while(stack.isNotEmpty() && stack.peek() <= arr[i]) {
            stack.pop()
        }

        printArr[i] = if(stack.isEmpty()) -1 else stack.peek()
        stack.push(arr[i])
    }

    repeat(count) {
        bw.write("${printArr[it]} ")
    }

    bw.flush()
}