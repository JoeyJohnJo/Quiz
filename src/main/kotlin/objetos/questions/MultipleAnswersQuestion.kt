package objetos.questions

class MultipleAnswersQuestion(question: String, answer: String = "",
                              private var possibleAnswers: MutableList<String> = mutableListOf()) : Question(question, answer) {
    override val type: String = "MULTIPLE_ANSWERS"

    override fun setAnswer() {
        println("Selecione a resposta correta")
        possibleAnswers.forEachIndexed { index, value ->
            println("[$index] - $value")
        }
        answer = possibleAnswers[readln().toInt()]
    }

    override fun printFunction(): Boolean {
        println(question)

        println("Digite a tecla correspondente a opção correta:")

        possibleAnswers.forEachIndexed { index, possibleAnswer -> println("$index - $possibleAnswer") }

        var selectedAnswer = readln().toInt()

        while (selectedAnswer !in possibleAnswers.indices) {
            println("Resposta inválida, tente novamente")
            selectedAnswer = readln().toInt()
        }

        return possibleAnswers[selectedAnswer] == answer
    }

    fun setPossibleAnswers() {
        println("Quantas respostas possíveis terá?")
        val quantidadeDeRespostasPossiveis = readln().toInt()
        for (i in 1..quantidadeDeRespostasPossiveis) {
            println("Digite a resposta possivel (resposta $i)")
            val resposta = readln()
            possibleAnswers.add(resposta)
        }
    }

    companion object {
        fun new(): MultipleAnswersQuestion {
            val pergunta = getQuestion()
            val q = MultipleAnswersQuestion(pergunta)
            q.setPossibleAnswers()
            q.setAnswer()
            return q
        }
    }
}
