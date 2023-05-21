package objetos.questions

import java.io.Serializable

abstract class Question(var question: String, var answer: String = "") : Serializable {

    abstract val type: String

    abstract fun printFunction(): Boolean

    open fun setAnswer() {
        answer = readln()
    }

    companion object {
        fun getQuestion(): String {
            println("Digite a pergunta")
            val pergunta = readln()
            return pergunta
        }
    }
}
