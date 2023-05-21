package telas.presentQuiz

import FileConstants.folderName
import objetos.Quiz
import java.io.File
import java.io.FileInputStream
import java.io.ObjectInputStream

fun abrirListaDeQuiz() {
    val allQuizzes = File(folderName).walk().filter { it.isFile }.toList()

    if (allQuizzes.isEmpty()) {
        println("Nenhum quiz encontrado no sistema\n\n\n")
        return
    }

    println("Pressione a tecla correspondente para abrir o quiz")

    allQuizzes.forEachIndexed { index, file -> println("[$index] -> ${file.name}") }

    val selectedIndex = readln().toInt()

    ObjectInputStream(FileInputStream(allQuizzes[selectedIndex])).use {
        val quiz = it.readObject() as Quiz
        quiz.show()
    }

}
