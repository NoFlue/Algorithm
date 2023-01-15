fun main() {
    val input = readln().toInt()
    var num = 666
    var count = 0
    while(true) {
        val numberToString = "$num"
        if(numberToString.contains("666")) {
            count++
            if(count == input) {
                println(numberToString)
                break
            }
        }
        num++
    }
}