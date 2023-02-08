import kotlin.math.max
import kotlin.math.round
import kotlin.math.roundToInt

fun main() {
    val stringBuilder = StringBuilder()
    val count = readln().toInt()
    val arr = IntArray(count)

    repeat(count) {
        arr[it] = readln().toInt()
    }

    val list = arr.sorted()

    stringBuilder.appendLine((list.sum().toDouble() / count).roundToInt())
    stringBuilder.appendLine(if(count % 2 == 0) (list[count / 2] + list[count / 2 + 1]) / 2 else list[count / 2])

    val map = HashMap<Int, Int>().withDefault { 0 }
    var max = 0
    var maxKey = 0

    list.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
        max = max(max, map[it]!!)
    }

    var maxNumCount = 0
    for(i in map.keys.sorted()) {
        if(map[i] == max) {
            maxNumCount++
            maxKey = i
            if(maxNumCount == 2) break
        }
    }

    stringBuilder.appendLine(maxKey)
    stringBuilder.appendLine(list[count - 1] - list[0])

    println(stringBuilder)
}