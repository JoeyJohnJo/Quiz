package telas.questions

import QuestionTypes

fun novaPerguntaMultiplasEscolhas(): List<Any> {
    val pergunta = getQuestion()

    println("Quantas respostas possíveis terá?")
    val quantidadeDeRespostasPossiveis = readln().toInt()
    val listaDeRespostasPossiveis = getPossibleAnswers(quantidadeDeRespostasPossiveis)
    val opcaoSelecionada = getCorrectAnswerIndex(listaDeRespostasPossiveis)
    return listOf(QuestionTypes.MULTIPLE_ANSWERS.value, pergunta, listaDeRespostasPossiveis, opcaoSelecionada)

}

private fun getCorrectAnswerIndex(listaDeRespostasPossiveis: MutableList<String>): Int {
    println("Selecione a resposta correta")
    listaDeRespostasPossiveis.forEachIndexed { index, value ->
        println("[$index] - $value")
    }
    val opcaoSelecionada = readln().toInt()
    return opcaoSelecionada
}

private fun getPossibleAnswers(quantidadeDeRespostasPossiveis: Int): MutableList<String> {
    val listaDeRespostasPossiveis = mutableListOf<String>()
    for (i in 1..quantidadeDeRespostasPossiveis) {
        println("Digite a resposta possivel (resposta $i)")
        val resposta = readln()
        listaDeRespostasPossiveis.add(resposta)
    }
    return listaDeRespostasPossiveis
}
