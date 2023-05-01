package telas.presentQuiz

import FileConstants.folderName
import QuestionTypes
import java.io.File
import java.io.FileInputStream
import java.io.ObjectInputStream

fun abrirListaDeQuiz() {
    println("Pressione a tecla correspondente para abrir o quiz")
    val allQuizzes = File(folderName).walk().filter { it.isFile }.toList()

    allQuizzes.forEachIndexed { index, file -> println("[$index] -> ${file.name}") }

    val selectedIndex = readln().toInt()

    ObjectInputStream(FileInputStream(allQuizzes[selectedIndex])).use {
        val quiz = it.readObject() as List<*>
        showQuiz(quiz)
    }

}

private fun showQuiz(quiz: List<*>) {
    println("\n\n\n----------------------------------")
    println(quiz.first())
    println("Quantidade de perguntas: ${quiz[1]}")
    val perguntas = quiz[2] as List<*>
    val resultados = perguntas.mapIndexed { index, question ->
        val questionList = question as List<*>
        println("Pergunta n. $index")
        Pair(index, QuestionTypes.valueOf(questionList.first() as String).printFunction(questionList))
    }

    val quantidadeDeAcertos = resultados.count { it.second }

    println("----------------------------------\n\n")
    println("Você acertou $quantidadeDeAcertos de ${quiz[1]} perguntas")
    resultados.forEach { pair ->
        println("Pergunta n. ${pair.first} - ${if (pair.second) "✅" else "❌"}")

    }
    println("\n\n\n\n")

}
