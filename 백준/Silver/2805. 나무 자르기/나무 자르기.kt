fun main() {
    val (treeCount, length) = readln().split(" ").map { it.toInt() }
    val tree = readln().split(" ").map { it.toInt() }.toIntArray()

    var start = 0L
    var end = 2147483647L
    var maxCutterLength = 0L

    while (start <= end) {
        val mid = (start + end) / 2

        if(isPossible(tree, length, mid)) {
            start = mid + 1
            maxCutterLength = mid
        } else {
            end = mid - 1
        }
    }

    println(maxCutterLength)
}

fun isPossible(tree: IntArray, requireLength: Int, cutterLength: Long): Boolean {
    var takenLength = 0L
    for(i in tree) {
        if(i > cutterLength) {
            takenLength += i - cutterLength
        }
    }

    return takenLength >= requireLength
}
