fun main() {
    val num = readln().split(" ").map { it.toInt() }
    val type = num[0] - num[1]
    
    for (i in 1..6) {
        if ((num[i] - num[i + 1]) != type) {
            println("mixed")
            return
        }
    }

    if(type == -1) {
        println("ascending")
    } else {
        println("descending")
    }
}