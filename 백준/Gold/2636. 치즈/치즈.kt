import java.util.*

lateinit var cheese: Array<IntArray>
lateinit var isVisit: Array<BooleanArray>
val dx = arrayOf(1, 0, -1, 0)
val dy = arrayOf(0, 1, 0, -1)

fun main() {
    val (row, column) = readln().split(" ").map { it.toInt() }
    isVisit = Array(row) { BooleanArray(column) { false } }
    cheese = Array(row) { IntArray(column) }
    repeat(row) {
        cheese[it] = readln().split(" ").map { it.toInt() }.toIntArray()
    }

    var time = 0
    var cheeseCount = getCheeseCount()
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    while(true) {
        queue.add(Pair(0, 0))
        time++

        // 겉부분 치즈가 1일 경우 2로 바꾸는 과정
        while(queue.isNotEmpty()) {
            val cur = queue.poll()
            for(i in 0 until 4) {
                val nx = cur.first + dx[i]
                val ny = cur.second + dy[i]
                if(nx < 0 || nx >= column || ny < 0 || ny >= row) continue
                if(isVisit[ny][nx]) continue

                isVisit[ny][nx] = true

                if(cheese[ny][nx] == 1) {
                    cheese[ny][nx] = 2
                    continue
                }

                queue.add(Pair(nx, ny))
            }
        }

        removeRottenCheese()
        repeat(row) {
            Arrays.fill(isVisit[it], false)
        }
        val tempCount = getCheeseCount()
        cheeseCount = if(tempCount == 0) cheeseCount else tempCount

        if(tempCount == 0) break
    }

    println("$time\n$cheeseCount")
}

fun getCheeseCount(): Int {
    var count = 0

    for(i in cheese.indices) {
        for(j in cheese[i].indices) {
            if(cheese[i][j] == 1) count++
        }
    }

    return count
}

fun removeRottenCheese() {
    for(i in cheese.indices) {
        for(j in cheese[i].indices) {
            if(cheese[i][j] == 2) cheese[i][j] = 0
        }
    }
}