package telas.presentQuiz

fun showMultipleAnswersQuestion(question: List<*>): Boolean {
    val possibleAnswers = question[2] as List<*>
    println(question[1])

    println("Digite a tecla correspondente a opção correta:")

    possibleAnswers.forEachIndexed { index, possibleAnswer -> println("$index - $possibleAnswer") }

    var selectedAnswer = readln().toInt()

    while (selectedAnswer !in possibleAnswers.indices) {
        println("Resposta inválida, tente novamente")
        selectedAnswer = readln().toInt()
    }

    return selectedAnswer == question[3]
}
