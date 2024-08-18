package JongManBook.CH6

fun main(){
    val n=4
    pick(n)
    print("\n\n\n")
    pickWithReculsive(n=n)
}

fun pick(n:Int){
    for(i in 0 .. n)
        for(j in i+1..n)
            for(k in j+1..n)
                for(l in k+1..n)
                    print("$i $j $k $l ")
}

/**
 *재귀함수 구현
 *1. 문제 분할 : 이미 선택 된 수, 마지막 수 n이 주어졌을 때 숫자 선택
 *2.  기저사례 선택 :
 *      a.
 *      a. 모든 수가 선택되면 선택된 수를 리턴
 *3. 구현
**/

fun pickWithReculsive(picked:MutableList<Int> =mutableListOf() ,n:Int){
    //기저사례
    if(picked.size==4) {
        picked.forEach{print("$it ")}
        return
    }

    //재귀함수 구현
    val smallest=if(picked.isEmpty())0 else picked.last()+1

    for(i in smallest..n){
        if(!picked.contains(i)){
            picked.add(i)
            pickWithReculsive(picked,n)
            picked.removeLast()
        }
    }

    return
}