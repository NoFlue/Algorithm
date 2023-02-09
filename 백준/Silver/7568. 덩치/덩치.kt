fun main() {
    val size = readln().toInt()
    val bodyList = Array(size) { Pair(0, 0) }

    repeat(size) {
        val (weight, height) = readln().split(" ").map { it.toInt() }
        bodyList[it] = Pair(weight, height)
    }

    repeat(size) {
        val (weight, height) = bodyList[it]
        var rank = 1

        for(i in 0 until size) {
            if(i == it) continue
            if(weight < bodyList[i].first && height < bodyList[i].second) {
                rank++
            }
        }

        print("$rank ")
    }
}