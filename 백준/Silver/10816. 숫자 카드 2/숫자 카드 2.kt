import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val stringBuilder = StringBuilder()
    val map = HashMap<Int, Int>()

    br.readLine()
    br.readLine().split(" ").map { it.toInt() }.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }
    br.readLine()
    br.readLine().split(" ").map { it.toInt() }.forEach {
        stringBuilder.append("${map[it] ?: 0} ")
    }

    println(stringBuilder)
}