package objetos.questions

class TrueOrFalseQuestion(question: String):  Question(question) {

    override val type: String = "TRUE_OR_FALSE"
    override fun printFunction(): Boolean {
        println(question)

        var answer = readln()

        while (!answer.equals("V", true) && !answer.equals("F", true)) {
            println("Resposta inválida, tente novamente.")
            answer = readln()
        }

        return answer == this.answer
    }

    override fun setAnswer() {
        println("Digite a resposta")
        answer = readln()

        while (!answer.equals("v", true) && !answer.equals("f", true)) {
            println("Resposta inválida, digite V ou F")
            answer = readln()
        }
    }

    companion object {
        fun new(): TrueOrFalseQuestion {
            val pergunta = getQuestion()
            val q = TrueOrFalseQuestion(pergunta)
            q.setAnswer()
            return q
        }
    }
}
