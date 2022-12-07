fun main() {
    val day = readln().toInt()
    val firstDayTree = readln().trim().split(" ").map { it.toInt() }
    val grownTreePerDay = readln().trim().split(" ").map { it.toInt() }

    val pair = mutableListOf<Pair<Int, Int>>().apply {
        repeat(day) {
            this.add(Pair(firstDayTree[it], grownTreePerDay[it]))
        }
        this.sortBy { it.second }
    }

    var result: Long = 0

    repeat(day) {
        result += pair[it].first + (pair[it].second * it)
    }

    println("$result ")
}