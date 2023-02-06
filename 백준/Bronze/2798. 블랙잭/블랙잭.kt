import kotlin.math.max

lateinit var cardList: IntArray
lateinit var usedCard: BooleanArray
var max = 0

fun main() {
    val (cardCount, targetNum) = readln().split(" ").map { it.toInt() }
    cardList = readln().split(" ").map { it.toInt() }.toIntArray()
    usedCard = BooleanArray(cardCount) { false }

    findSumNumber(0, 3, 0, targetNum)

    println(max)
}

fun findSumNumber(current: Int, target: Int, currentNum: Int, targetNum: Int) {
    if(currentNum > targetNum) return

    if(current == target) {
        max = max(currentNum, max)
        return
    }

    for(i in cardList.indices) {
        if(usedCard[i]) continue

        usedCard[i] = true
        findSumNumber(current + 1, target, currentNum + cardList[i], targetNum)
        usedCard[i] = false
    }
}