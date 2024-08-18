package JongManBook.CH6

private val n=8
private val board= Array(n){ Array(n){""} }
fun main(){


}


/**
 * 재귀함수 구현
 * 1. 문제 분할 : 문자가 주어질때 시작 좌표의 상하좌우,대각선이 문자의 첫글자와 같은지 검사한다.
 * 2. 기저 사례 선택:
 *      a. 검사한 좌표의 글자가 첫글자와 다르다면 false를 반환
 *      b. 검사한 좌표의 글자가 첫글자와 같고, 문자의 길이가 1이라면 true를 반환
 * 3. 구현
 */
fun hasWord(startX:Int,startY:Int,restWord:String):Boolean{

    //범위 체크
    if(startX>=board.size||startY>=board[0].size) return false
    //기저사례 구현
    if(board[startX][startY][0]!=restWord.first()) return false
    if(restWord.length==1)return true

    // 방향 배열 : 상하좌우,오른위,오른아래,왼위,왼아래
    val dx= intArrayOf(0,0,-1,1,1,1,-1,-1)
    val dy= intArrayOf(1,-1,0,0,1,-1,1,-1)

    var res=false

    for(direction in 0 until dx.size){
        if(hasWord(dx[direction],dy[direction],restWord.substring(1)))res=true
    }
    return res
}
