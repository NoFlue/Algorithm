import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val times = reader.readLine().toInt()
    var char: String = " "
    for(i in times downTo 1){
        for(j in 1..times){
            if(j == i)
                char = "*"
            writer.write(char)
        }
        char = " "
        writer.newLine()
    }
    writer.flush()
    writer.close()
    reader.close()
}