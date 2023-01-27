import java.io.BufferedReader
import java.io.InputStreamReader

data class Node(
    val data: Char,
    var left: Node? = null,
    var right: Node? = null
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val count = br.readLine().toInt()
    val nodeList = Array(count) { index ->
        Node('A' + index)
    }

    repeat(count) {
        val (root, left, right) = br.readLine().split(" ").map { it.single() }
        nodeList[root - 'A'].left = if (left == '.') null else nodeList[left - 'A']
        nodeList[root - 'A'].right = if (right == '.') null else nodeList[right - 'A']
    }

    preorder(nodeList[0])
    println()
    inorder(nodeList[0])
    println()
    postorder(nodeList[0])
}

fun preorder(root: Node) {
    print(root.data)
    if(root.left != null) preorder(root.left!!)
    if(root.right != null) preorder(root.right!!)
}

fun inorder(root: Node) {
    if(root.left != null) inorder(root.left!!)
    print(root.data)
    if(root.right != null) inorder(root.right!!)
}

fun postorder(root: Node) {
    if(root.left != null) postorder(root.left!!)
    if(root.right != null) postorder(root.right!!)
    print(root.data)
}