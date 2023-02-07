import java.io.BufferedReader
import java.io.InputStreamReader

class AgeComparator: Comparator<Pair<Int, String>> {
    override fun compare(o1: Pair<Int, String>, o2: Pair<Int, String>): Int {
        return when {
            o1.first > o2.first -> 1
            o1.first == o2.first -> 0
            else -> -1
        }
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val count = br.readLine().toInt()
    val arr = Array(count) { Pair(0, "") }

    repeat(count) {
        val (age, name) = br.readLine().split(" ")
        arr[it] = Pair(age.toInt(), name)
    }

    for((age, name) in arr.sortedWith(AgeComparator())) {
        println("$age $name")
    }
}