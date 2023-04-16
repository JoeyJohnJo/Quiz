package telas

fun abrirMenuCriarNovoQuiz() {
    println("Novo Quiz")
    println("de que se trata o novo quiz?")
    var TemaQuiz = readln()

    println("Cuantas perguntas tera o quiz?")
    var Cuantidadeperguntas = readln().toInt()

    println("selecione a tecla correspondente para a primera pergunta")

    println("A=escolher opcao correta")
    println("B=resposta livre")
    println("C=verdadeiro o falso")

    var OpcaoSelecionada = readln()

    println("primera pergunta")
    var PrimeraPergunta=readln()
    var Resposta1=readln()
}
