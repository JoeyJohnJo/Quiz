package objetos.questions

class FreeTextAnswerQuestion(question: String, answer: String): Question(question, answer) {
    override val type: String = "FREE_TEXT_ANSWER"
    override fun printFunction(): Boolean {
        println(question)
        val answer = readln()
        return answer.equals(this.answer, true)
    }

    companion object {
        fun new(): FreeTextAnswerQuestion {
            val pergunta = getQuestion()

            println("Digite a resposta")
            val resposta = readln()
            return FreeTextAnswerQuestion(pergunta, resposta)
        }

    }

}
