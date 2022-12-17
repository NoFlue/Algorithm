val tile = IntArray(1001) { 0 }

fun main() {
    print(tile(readln().toInt()))
}

fun tile(x: Int): Int {
    if(x == 0) return 0
    if(x == 1) return 1
    if(x == 2) return 2
    if(tile[x] != 0) return tile[x]
    tile[x] = tile(x - 1) + tile(x - 2)
    return tile[x] % 10007
}