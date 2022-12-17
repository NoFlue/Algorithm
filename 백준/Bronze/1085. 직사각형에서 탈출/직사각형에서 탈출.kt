import kotlin.math.min

fun main() {
    val (x, y, w, h) = readln().split(" ").map { it.toInt() }
    val width = min(x, w - x)
    val height = min(y, h - y)
    print(min(width, height))
}