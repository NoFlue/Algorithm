fun main() {
    val s = readln()
    val t = StringBuilder(readln())

    var isVaild = false

    while(s.length != t.length) {
        if(t.last() == 'A') {
            t.deleteCharAt(t.lastIndex)
        } else {
            t.deleteCharAt(t.lastIndex).reverse()
        }

        if(s == t.toString()) isVaild = true
    }

    println(if(isVaild) 1 else 0)
}