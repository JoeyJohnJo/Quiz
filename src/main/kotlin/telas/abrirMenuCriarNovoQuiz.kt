package telas

import FileConstants.folderName
import QuestionOptions
import QuestionOptions.isInvalidOption
import objetos.Quiz
import objetos.questions.FreeTextAnswerQuestion
import objetos.questions.MultipleAnswersQuestion
import objetos.questions.Question
import objetos.questions.TrueOrFalseQuestion
import java.io.File
import java.io.FileOutputStream
import java.io.ObjectOutputStream

fun abrirMenuCriarNovoQuiz() {
    println("Novo Quiz")
    println("de que se trata o novo quiz?")
    val temaQuiz = readln()

    println("Cuantas perguntas tera o quiz?")
    val cuantidaDePerguntas = readln().toInt()
    val listaDePerguntas = mutableListOf<Question>()

    for (i in 1..cuantidaDePerguntas) {
        listaDePerguntas.add(criarNovaPergunta())
    }

    println("Deseja salvar o quiz. Aperte S para sim ou qualquer tecla para não")
    val desejaSalvar = readln()
    if (desejaSalvar.equals("s", true)) {
        println("Salvando...")
        val quiz = Quiz(temaQuiz, listaDePerguntas)
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

private fun criarNovaPergunta(): Question {
    println("Selecione o tipo para a pergunta")

    val selectedOption = getSelectedQuestionOption()

    return when (selectedOption) {
        QuestionOptions.multipleAnswers -> MultipleAnswersQuestion.new()
        QuestionOptions.freeAnswer -> FreeTextAnswerQuestion.new()
        QuestionOptions.trueOrFalse -> TrueOrFalseQuestion.new()
        else -> throw Exception()
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
