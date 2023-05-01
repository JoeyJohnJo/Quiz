package telas

import telas.presentQuiz.abrirListaDeQuiz

/**
 * Exibe o menu inicial do aplicativo e permite ao usuário navegar pelas opções.
 */
fun abrirMenuInicial() {
    println("\n\n--------------- GERADOR DE QUIZ ---------------")

    while (true) {
        println("Aperte a tecla correspondente para selecionar uma opção")
        println("${Nav.listarQuizzes} - Listar quizzes existentes")
        println("${Nav.criarNovoQuiz} - Criar novo quiz")
        println("${Nav.fecharAplicativo} - Fechar aplicativo")

        // Aguarda a seleção do usuário e navega para a opção correspondente
        if (navegarParaOpcaoSelecionada()) break

    }
}

/**
 * Lê a entrada do usuário e navega para a opção correspondente.
 * @return true se o usuário selecionou a opção "Fechar aplicativo", false caso contrário.
 */
private fun navegarParaOpcaoSelecionada(): Boolean {
    val opcaoSelecionada = readln()

    if (opcaoSelecionada == Nav.listarQuizzes)
        abrirListaDeQuiz() // Exibe a lista de quizzes existentes
    else if (opcaoSelecionada == Nav.criarNovoQuiz)
        abrirMenuCriarNovoQuiz() // Exibe o menu para criar um novo quiz
    else if (opcaoSelecionada.lowercase() == Nav.fecharAplicativo.lowercase()) {
        sairPrograma() // Fecha o aplicativo
        return true
    } else opcaoNaoReconhecida() // Exibe uma mensagem de erro para opções inválidas
    return false
}
