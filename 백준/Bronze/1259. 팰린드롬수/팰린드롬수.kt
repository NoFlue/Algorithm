fun main() {
    do {
        val input = readln()
        if(input == "0") break
        
        var isValid = true
        for(i in 0 until input.length / 2) {
            if(input[i] != input[input.length - i - 1]) {
                isValid = false
                break
            }
        }

        println(if (isValid) "yes" else "no")
    } while (true)
}