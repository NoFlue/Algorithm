import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.text.StringBuilder

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    val del = br.readLine()
    val stringBuilder = StringBuilder()

    for(i in str) {
        stringBuilder.append(i)
        if(stringBuilder.length >= del.length) {
            var same = true
            for(i in del.indices) {
                if(stringBuilder[stringBuilder.length - del.length + i] != del[i]) {
                    same = false
                    break
                }
            }

            if(same) {
                stringBuilder.delete(stringBuilder.length - del.length, stringBuilder.length)
            }
        }
    }

    println(if(stringBuilder.length == 0) "FRULA" else stringBuilder)
}