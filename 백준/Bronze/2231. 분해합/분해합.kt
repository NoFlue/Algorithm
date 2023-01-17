fun main() {
    val input = readln().toInt()
    for(i in input / 2..input) {
        var sum = i
        var num = i
        while(num > 0) {
            sum += num % 10
            num /= 10
        }

        if(input == sum) {
            println(i)
            return
        }
    }
    println("0")
}