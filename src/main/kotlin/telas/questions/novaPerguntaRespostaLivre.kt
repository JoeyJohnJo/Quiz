package telas.questions

fun novaPerguntaRespostaLivre(): List<String> {
    val pergunta = getQuestion()

    println("Digite a resposta")
    val resposta = readln()
    return listOf(pergunta, resposta)
}
