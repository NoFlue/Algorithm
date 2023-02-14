fun main() {
    val count = readln().toInt()
    val budget = readln().split(" ").map { it.toInt() }.toIntArray()
    val nationalBudget = readln().toInt()

    var start = 0
    var end = budget.max()
    var max = 0

    while(start <= end) {
        val mid = (start + end) / 2

        if(isPossible(budget, nationalBudget, mid)) {
            max = mid
            start = mid + 1
        } else {
            end = mid - 1
        }
    }

    println(max)
}

fun isPossible(budget: IntArray, nationalBudget: Int, limit: Int): Boolean {
    var total = 0
    for(i in budget) {
        total += if(i >= limit) limit else i
    }

    return total <= nationalBudget
}