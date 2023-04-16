package telas

import QuestionOptions
import QuestionOptions.isInvalidOption
import telas.questions.novaPerguntaMultiplasEscolhas
import telas.questions.novaPerguntaRespostaLivre
import telas.questions.novaPerguntaVerdadeiroOuFalso

fun abrirMenuCriarNovoQuiz() {
    println("Novo Quiz")
    println("de que se trata o novo quiz?")
    val temaQuiz = readln()

    println("Cuantas perguntas tera o quiz?")
    val cuantidaDePerguntas = readln().toInt()
    val listaDePerguntas = mutableListOf<List<Any>>()

    for (i in 1..cuantidaDePerguntas) {
        listaDePerguntas.add(criarNovaPergunta())
    }

    // Agrupar e salvar
    // O tema
    // Quantidade de perguntas
    // Lista de perguntas e respostas
}

private fun criarNovaPergunta(): List<Any> {
    println("Selecione o tipo para a pergunta")

    val selectedOption = getSelectedQuestionOption()

    return when (selectedOption) {
        QuestionOptions.multipleAnswers -> novaPerguntaMultiplasEscolhas()
        QuestionOptions.freeAnswer -> novaPerguntaRespostaLivre()
        QuestionOptions.trueOrFalse -> novaPerguntaVerdadeiroOuFalso()
        else -> listOf()
    }

}

private fun getSelectedQuestionOption(): String {
    var selectedOption = ""
    while (selectedOption == "") {
        println("${QuestionOptions.multipleAnswers} = Multiplas escolhas")
        println("${QuestionOptions.freeAnswer} = resposta livre")
        println("${QuestionOptions.trueOrFalse} = verdadeiro o falso")

        selectedOption = readln()

        if (selectedOption.isInvalidOption()) {
            opcaoNaoReconhecida()
            selectedOption = ""
        }
    }
    return selectedOption.uppercase()
}
