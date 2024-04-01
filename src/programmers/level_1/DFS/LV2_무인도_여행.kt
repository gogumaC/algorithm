import java.util.*

class Solution {
    
    lateinit var isVisited:Array<BooleanArray>
    lateinit var maps:Array<String>
    
    fun solution(maps: Array<String>): IntArray {
        val answer=mutableListOf<Int>()
        this.maps=maps
        isVisited=Array(maps.size){BooleanArray(maps[0].length){false}}
        for(i in maps.indices){
            for(j in maps[0].indices){
                if(isVisited[i][j]||maps[i][j]=='X') continue
                isVisited[i][j]=true
                answer.add(dfs(i,j))
            }
        }
        return if(answer.isEmpty()) intArrayOf(-1) else answer.sorted().toIntArray()
    }
    
    val off=arrayOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
    fun dfs(x:Int,y:Int):Int{
        var res=(maps[x][y]-'0').toInt()
        for((ox,oy) in off){
            val nx=x+ox
            val ny=y+oy
            if(nx in 0 until maps.size && ny in 0 until maps[0].length){
                if(maps[nx][ny]!='X'&&!isVisited[nx][ny]){
                    isVisited[nx][ny]=true
                    res+=dfs(nx,ny)
                }
            }
        }
        return res
    }
}