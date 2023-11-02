package solved.ac.class_4

import java.io.BufferedReader
import java.io.InputStreamReader

class BOJ1191() {

    val sb = StringBuilder()
    fun solve() {

        val br = BufferedReader(InputStreamReader(System.`in`))

        val n = br.readLine().toInt()
        val tree = mutableMapOf<String, Node>()

        for (i in 0 until n) {
            val (node, left, right) = br.readLine().split(" ")
            tree[node] = Node(node, left, right)
        }

        preorder(n, tree)
        sb.append("\n")
        inorder(n, tree)
        sb.append("\n")
        postorder(n, tree)

        println(sb)

    }

    fun preorder(n: Int, tree: MutableMap<String, Node>, current: String = "A") {
        sb.append(current)
        val left = tree[current]!!.leftChild
        val right = tree[current]!!.rightChild
        if (left != ".") preorder(n, tree, left)
        if (right != ".") preorder(n, tree, right)
        else return
    }

    fun inorder(n: Int, tree: MutableMap<String, Node>, current: String = "A") {
        val left = tree[current]!!.leftChild
        val right = tree[current]!!.rightChild

        if (left != ".") inorder(n, tree, left)
        sb.append(current)
        if (right != ".") inorder(n, tree, right)
        else return
    }

    fun postorder(n: Int, tree: MutableMap<String, Node>, current: String = "A") {

        val left = tree[current]!!.leftChild
        val right = tree[current]!!.rightChild
        if (left != ".") postorder(n, tree, left)
        if (right != ".") postorder(n, tree, right)
        sb.append(current)
        return
    }

    data class Node(val value: String, val leftChild: String, val rightChild: String)

}

fun main() {
    BOJ1191().solve()
}