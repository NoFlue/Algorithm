import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var isVisit: BooleanArray
lateinit var graph: Array<MutableList<Int>>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    graph = Array(n + 1) { mutableListOf() }
    isVisit = BooleanArray(n + 1) { false }
    repeat(m) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }

    var count = 0
    for(i in 1..n) {
        if(!isVisit[i]) {
            count++
            dfs(i)
        }
    }

    println(count)
}

fun dfs(position: Int) {
    isVisit[position] = true
    for(i in graph[position]) {
        if(!isVisit[i]) {
            dfs(i)
        }
    }
}