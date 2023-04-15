package programmers.level_1

//추억점수 : https://school.programmers.co.kr/learn/courses/30/lessons/176963

fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
    var answer: IntArray = IntArray(photo.size){0}

    var nameMap = name.withIndex().associate{it.value to yearning[it.index]}

    for(photoIndex in photo.indices){
        photo[photoIndex].forEach{name->
            nameMap[name]?.let{ answer[photoIndex]+=it }
        }
    }
    return answer
}