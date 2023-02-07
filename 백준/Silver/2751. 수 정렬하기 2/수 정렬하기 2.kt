import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stringBuilder = StringBuilder()
    val count = br.readLine().toInt()
    val arr = IntArray(count)
    
    repeat(count) {
        arr[it] = br.readLine().toInt()
    }

    arr.sorted().forEach(stringBuilder::appendLine)

    println(stringBuilder)
}