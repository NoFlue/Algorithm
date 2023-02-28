import java.util.*

fun main() {
    val (t, distance, weight) = readln().split(" ").map { it.toInt()}
    val truck = LinkedList<Int>()
    val bridge = LinkedList<Pair<Int, Int>>()
    truck.addAll(readln().split(" ").map { it.toInt() })

    var time = 0
    while (truck.isNotEmpty() || bridge.isNotEmpty()) {
        time++

        repeat(bridge.size) {
            bridge[it] = Pair(bridge[it].first, bridge[it].second + 1)
        }

        if(bridge.isNotEmpty() && bridge.first.second > distance) {
            bridge.removeFirst()
        }

        if(truck.isNotEmpty()) {
            var totalWeight = 0
            bridge.forEach { totalWeight += it.first }
            if(totalWeight + truck.first <= weight) {
                bridge.add(Pair(truck.removeFirst(), 1))
            }
        }
    }
    println(time)
}