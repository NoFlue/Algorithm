fun main() {
    val arrSize = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    val targetSize = readln().toInt()
    val target = readln().split(" ").map { it.toInt() }.toIntArray()

    repeat(targetSize) {
        val targetNumber = target[it]
        var start = 0
        var end = arrSize - 1
        var findNumber = false

        while (start <= end) {
            val mid = (start + end) / 2

            when {
                arr[mid] == targetNumber -> {
                    findNumber = true
                    break
                }
                arr[mid] > targetNumber -> end = mid - 1
                else -> start = mid + 1
            }
        }

        println(if(findNumber) 1 else 0)
    }
}