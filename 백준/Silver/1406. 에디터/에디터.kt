import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = StringBuilder(br.readLine())
    val commandTime = br.readLine().toInt()
    val stack = Stack<Char>()

    repeat(commandTime) {
        val cmd = br.readLine()
        when(cmd) {
            "L" -> {
                if(str.isNotEmpty()) {
                    val ch = str.last()
                    str.setLength(str.length - 1)
                    stack.add(ch)
                }
            }
            "D" -> {
                if(!stack.empty()) {
                    str.append(stack.pop())
                }
            }
            "B" -> {
                if(str.isNotEmpty()) {
                    str.setLength(str.length - 1)
                }
            }
            else -> {
                val ch = cmd.split(" ")[1]
                str.append(ch)
            }
        }
    }

    while(!stack.empty()) {
        str.append(stack.pop())
    }

    println(str)
}