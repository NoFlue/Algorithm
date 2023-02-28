import java.util.*

fun main() {
    val buildingCount = readln().toInt()
    val stack = Stack<Int>()
    val building = IntArray(buildingCount)
    repeat(buildingCount) {
        building[it] = readln().toInt()
    }

    var total: Long = 0

    for(i in building) {
        val height = i
        while(stack.isNotEmpty() && stack.peek() <= height) {
            stack.pop()
        }
        /* pop이 안된 숫자는 top 보다 큰 건물 이므로
            이 건물 또한 height 높이의 건물을 볼 수 있기 때문에
            stack의 size 만큼 더해준다. */
        total += stack.size
        stack.push(height)
    }

    println(total)
}