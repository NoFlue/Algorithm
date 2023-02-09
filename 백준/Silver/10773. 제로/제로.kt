import java.util.Stack

fun main() {
    val stack = Stack<Int>()

    repeat(readln().toInt()) {
        val num = readln().toInt()
        if(num == 0) {
            stack.pop()
        } else {
            stack.push(num)
        }
    }

    println(stack.sum())
}