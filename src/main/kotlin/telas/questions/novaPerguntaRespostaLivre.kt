package telas.questions

import QuestionTypes

fun novaPerguntaRespostaLivre(): List<String> {
    val pergunta = getQuestion()

    println("Digite a resposta")
    val resposta = readln()
    return listOf(QuestionTypes.FREE_TEXT_ANSWER.value, pergunta, resposta)
}
