import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    BufferedReader(InputStreamReader(System.`in`)).use { reader ->
        val count = reader.readLine().toInt()
        val arr = Array(count) { "" }

        repeat(count) {
            arr[it] = reader.readLine()
        }

        val sortedArr = arr.sortedWith(comparator = compareBy({ it.length }, {it})).toSet()

        sortedArr.forEach {
            println(it)
        }
    }
}