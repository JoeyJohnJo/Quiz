package telas.presentQuiz

fun showFreeTextAnswerQuestion(question: List<*>): Boolean {
    println(question[1])
    val answer = readln()
    return answer.equals(question[2] as String, true)
}
