package objetos

import objetos.questions.Question
import java.io.Serializable

class Quiz(var tema: String, var questions: List<Question>) : Serializable {

    fun show() {
        println("\n\n\n----------------------------------$tema")
        println("Quantidade de perguntas: ${questions.size}")

        val resultados = questions.mapIndexed { index, question ->
            println("Pergunta n. $index")
            Pair(index, question.printFunction())
        }

        val quantidadeDeAcertos = resultados.count { it.second }

        println("----------------------------------\n\n")
        println("Você acertou $quantidadeDeAcertos de ${questions.size} perguntas")
        resultados.forEach { pair ->
            println("Pergunta n. ${pair.first} - ${if (pair.second) "✅" else "❌"}")

        }
        println("\n\n\n\n")

    }
}
