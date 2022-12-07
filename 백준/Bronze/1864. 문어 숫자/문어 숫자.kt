val correspond = mapOf(
    '-' to 0,
    '\\' to 1,
    '(' to 2,
    '@' to 3,
    '?' to 4,
    '>' to 5,
    '&' to 6,
    '%' to 7,
    '/' to -1
)

val stringBuilder = StringBuffer()


fun main() {
    while (true) {
        val number = readln()
        if (number == "#") break

        var result: Int = 0

        number.mapIndexed { index, value ->
            correspond[value]!! * ( pow(8, number.length - index - 1) )
        }.forEach { result += it }

        stringBuilder.append("$result\n")
    }

    println(stringBuilder.toString())
}

fun pow(a: Int, b: Int) : Int {
    if(b == 0) return 1

    val aPowerBDivideByTwo = pow(a, b / 2)
    val aPowerBDivideByTwoSquared = aPowerBDivideByTwo * aPowerBDivideByTwo

    if(b % 2 == 0) {
        return aPowerBDivideByTwoSquared
    } else {
        return aPowerBDivideByTwoSquared * a
    }
}