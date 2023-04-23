package telas

import FileConstants.folderName
import java.io.File
import java.io.FileInputStream
import java.io.ObjectInputStream

fun abrirListaDeQuiz() {
    println("Pressione a tecla correspondente para abrir o quiz")
    val allQuizzes = File(folderName).walk().filter { it.isFile }.toList()

    allQuizzes.forEachIndexed { index, file -> println("[$index] -> ${file.name}") }

    val selectedIndex = readln().toInt()

    ObjectInputStream(FileInputStream(allQuizzes[selectedIndex])).use {
        val quiz = it.readObject()
    }

}
