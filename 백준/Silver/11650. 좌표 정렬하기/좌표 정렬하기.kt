class PosComparator: Comparator<Pair<Int, Int>> {
    override fun compare(o1: Pair<Int, Int>, o2: Pair<Int, Int>): Int {
        return if(o1.first != o2.first) {
            o1.first.compareTo(o2.first)
        } else {
            o1.second.compareTo(o2.second)
        }
    }
}

fun main() {
    val list = mutableListOf<Pair<Int, Int>>()
    repeat(readln().toInt()) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        list.add(Pair(a, b))
    }

    list.sortedWith(comparator = PosComparator()).forEach { println("${it.first} ${it.second}") }
}