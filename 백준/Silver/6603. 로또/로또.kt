fun main() {
    while (true) {
        val numberList = readln().trim().split(" ").map { it.toInt() }
        val number = numberList[0]
        if(number == 0) break

        val arr: Array<Int> = Array(number) { i -> numberList[i + 1] }
        val visited: Array<Boolean> = Array(number){ false }

        combination(arr, visited, 0, number, 6)
        println()
    }
}

fun combination(arr: Array<Int>, visited: Array<Boolean>, start: Int, n: Int, r: Int){
    if(r == 0) {
        printNumber(arr, visited, n)
        return
    }

    for(i in start.until(n)) {
        visited[i] = true
        combination(arr, visited, i + 1, n, r - 1)
        visited[i] = false
    }
}

fun printNumber(arr: Array<Int>, visited: Array<Boolean>, n: Int) {
    repeat(n) {
        if(visited[it]) {
            print("${arr[it]} ")
        }
    }
    println()
}