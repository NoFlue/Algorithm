fun main() {
    repeat(readln().toInt()) {
        var result = 0
        for(i in readln()) {
            if(i == '(') {
                result += if(result >= 0) 1 else -1  // ())( 와 같은 케이스 막기
            } else {
                result -= 1
            }
        }

        println(if(result == 0) "YES" else "NO")
    }
}