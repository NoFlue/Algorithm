import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = HashMap<String, Int>()

    repeat(n) {
        map.put(readLine(), it)
    }

    var count = 0
    repeat(m) {
        if(map.containsKey(readLine())) count++
    }

    print(count)
}