val stringBuilder = StringBuilder()
val vowel = arrayOf('a', 'e', 'i', 'o', 'u')

fun main() {
    val (length, size) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").sorted()
    val isUsed = BooleanArray(size) { false }

    solve(0, length, arr, isUsed)
}

fun solve(count: Int, length: Int, arr: List<String>, isUsed: BooleanArray) {
    if(count >= 2) {
        if(!stringBuilder.toString().isSorted()) return
    }

    if(count == length) {
        var (vow, con) = Pair(0, 0)
        for(c in stringBuilder) {
            if(c in vowel) vow++
            else con++
        }
        if(vow >= 1 && con >= 2) println(stringBuilder)
        return
    }

    for(i in arr.indices) {
        if(!isUsed[i]) {
            isUsed[i] = true
            stringBuilder.append(arr[i])
            solve(count + 1, length, arr, isUsed)
            stringBuilder.deleteCharAt(stringBuilder.lastIndex)
            isUsed[i] = false
        }
    }
}

fun String.isSorted(): Boolean {
    for(i in 0 until this.length - 1) {
        if(this[i] < this[i + 1]) continue
        return false
    }
    return true
}