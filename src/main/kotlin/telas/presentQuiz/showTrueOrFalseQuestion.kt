package telas.presentQuiz

fun showTrueOrFalseQuestion(question: List<*>): Boolean {
    println(question[1])
    var answer = readln()

    while (!answer.equals("V", true) && !answer.equals("F", true)) {
        println("Resposta inválida, tente novamente.")
        answer = readln()
    }

    return answer == question[2]
}
