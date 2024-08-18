package solved.ac.class_3

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map {
        it.toInt()
    }

    val noListenList = mutableSetOf<String>()
    val noListenWatchList = mutableListOf<String>()

    for (i in 0 until n) {
        noListenList.add(br.readLine())
    }

    for (i in 0 until m) {
        val noWatch = br.readLine()
        if (noListenList.contains(noWatch)) noListenWatchList.add(noWatch)
    }

    noListenWatchList.sort()
    StringBuilder().apply {
        append(noListenWatchList.size)
        append("\n")
        noListenWatchList.forEach {
            append("$it\n")
        }
        print(this)
    }

}