package programmers.level_1

fun main(){

    val players=arrayOf("mumu", "soe", "poe", "kai", "mine")
    val calling=arrayOf("kai", "kai", "mine", "mine")

    val playerRankMap:MutableMap<Int,String> = mutableMapOf()
    players.forEachIndexed { index, s ->
        playerRankMap.put(index,s)
    }

    calling.forEachIndexed{ index, s->
        val old=playerRankMap[index]
       // val prev=playerRankMap[]
    }
}