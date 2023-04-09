package telas

fun abrirMenuInicial() {
    var opcaoSelecionada = ""

    while (opcaoSelecionada.lowercase() != "x") {
        println("\n\n--------------- GERADOR DE QUIZ ---------------")
        println("Aperte a tecla correspondente para selecionar uma opção")
        println("1 - Listar quizzes existentes")
        println("2 - Criar novo quiz")
        println("X - Fechar aplicativo")

        opcaoSelecionada = readln()
    }
}
