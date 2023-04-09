package telas

fun abrirMenuInicial() {
    println("\n\n--------------- GERADOR DE QUIZ ---------------")

    while (true) {
        println("Aperte a tecla correspondente para selecionar uma opção")
        println("${Nav.listarQuizzes} - Listar quizzes existentes")
        println("${Nav.criarNovoQuiz} - Criar novo quiz")
        println("${Nav.fecharAplicativo} - Fechar aplicativo")

        if (navegarParaOpcaoSelecionada()) break

    }
}

private fun navegarParaOpcaoSelecionada(): Boolean {
    val opcaoSelecionada = readln()

    if (opcaoSelecionada == Nav.listarQuizzes)
        abrirListaDeQuiz()
    else if (opcaoSelecionada == Nav.criarNovoQuiz)
        abrirMenuCriarNovoQuiz()
    else if (opcaoSelecionada.lowercase() == Nav.fecharAplicativo.lowercase()) {
        sairPrograma()
        return true
    } else opcaoNaoReconhecida()
    return false
}
