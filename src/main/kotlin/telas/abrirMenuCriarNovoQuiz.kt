package telas

import FileConstants.folderName
import QuestionOptions
import QuestionOptions.isInvalidOption
import telas.questions.novaPerguntaMultiplasEscolhas
import telas.questions.novaPerguntaRespostaLivre
import telas.questions.novaPerguntaVerdadeiroOuFalso
import java.io.File
import java.io.FileOutputStream
import java.io.ObjectOutputStream

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

    println("Deseja salvar o quiz. Aperte S para sim ou qualquer tecla para não")
    val desejaSalvar = readln()
    if (desejaSalvar.equals("s", true)) {
        println("Salvando...")
        val quiz = listOf(temaQuiz, cuantidaDePerguntas, listaDePerguntas)
        saveToDisk(quiz, "$folderName/Quiz - $temaQuiz")
        println("Seu quiz foi salvo")
    }
}

fun saveToDisk(obj: Any, fileName: String) {
    var actualFileName = fileName
    File(folderName).mkdirs()
    if (File(fileName).exists()) {
        val count = File(folderName).walk().filter {
            it.path.startsWith(fileName.replace("/", "\\"))
        }.count()
        actualFileName = "$fileName ($count)"
    }
    ObjectOutputStream(FileOutputStream(actualFileName)).use { it.writeObject(obj) }
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
