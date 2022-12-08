import java.lang.StringBuilder

val frontWord = listOf("c", "j", "n", "m", "t", "s", "l", "d", "qu")
val vowels = listOf('a', 'i', 'u', 'e', 'o', 'h')

fun main() {
    val text = readln().trim().split(" ", "-")

    var wordCount = 0

    for(t in text) {
        if(!t.contains("'")) {
            wordCount++
            continue
        }

        val splitWord = t.split("'")

        if(frontWord.contains(splitWord[0]) && vowels.contains(splitWord[1].toCharArray().get(0))) {
            wordCount += 2
        } else {
            wordCount++
        }
    }

    println(if(text[0] == "") 0 else wordCount)
}