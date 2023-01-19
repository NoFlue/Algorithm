import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val token = StringTokenizer(readLine())
    val up = token.nextToken().toInt()
    val down = token.nextToken().toInt()
    val height = token.nextToken().toInt()
    if((height - up) % (up - down) != 0)
        println((height - up) / (up - down) + 2)
    else
        println((height - up) / (up - down) + 1)
}