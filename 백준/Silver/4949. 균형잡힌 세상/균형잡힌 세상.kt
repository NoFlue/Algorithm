import java.util.Stack

fun main() {
    val stack = Stack<Char>()

    while (true) {
        val str = readln()
        if(str == ".") break

        var isBalance = true

        for(c in str) {
            if(c == '(' || c == '[') {
                stack.push(c)
            } else if(c == ')' || c == ']') {
                if(stack.isEmpty()) {
                    isBalance = false
                    break
                }

                val openBracket = stack.pop()
                if((openBracket == '(' && c == ')') || (openBracket == '[' && c == ']')) continue
                isBalance = false
                break
            }
        }

        if(stack.isNotEmpty()) {
            isBalance = false
        }

        println(if(isBalance) "yes" else "no")
        stack.clear()
    }
}