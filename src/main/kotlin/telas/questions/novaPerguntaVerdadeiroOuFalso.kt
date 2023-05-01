package telas.questions

import QuestionTypes

fun novaPerguntaVerdadeiroOuFalso(): List<Any> {
    val pergunta = getQuestion()
    val resposta = getAnswer()
    return listOf(QuestionTypes.TRUE_OR_FALSE.value, pergunta, resposta)
}

private fun getAnswer(): String {
    println("Digite a resposta")
    var resposta = readln()

    while (!resposta.equals("v", true) && !resposta.equals("f", true)) {
        println("Resposta inválida, digite V ou F")
        resposta = readln()
    }
    return resposta
}
