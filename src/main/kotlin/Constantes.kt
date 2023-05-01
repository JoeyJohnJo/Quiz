import telas.presentQuiz.showFreeTextAnswerQuestion
import telas.presentQuiz.showMultipleAnswersQuestion
import telas.presentQuiz.showTrueOrFalseQuestion

/**
 * Um objeto que contém constantes para as opções de navegação do aplicativo.
 */
object Nav {
    /**
     * Uma constante para a opção "Listar quizzes existentes".
     */
    const val listarQuizzes = "1"

    /**
     * Uma constante para a opção "Criar novo quiz".
     */
    const val criarNovoQuiz = "2"

    /**
     * Uma constante para a opção "Fechar aplicativo".
     */
    const val fecharAplicativo = "X"
}

object QuestionOptions {
    const val multipleAnswers = "A"
    const val freeAnswer = "B"
    const val trueOrFalse = "C"
    private val validOptions = listOf(multipleAnswers, freeAnswer, trueOrFalse)
    fun String.isValidOption() = validOptions.any { it.lowercase() == this.lowercase() }

    fun String.isInvalidOption() = !this.isValidOption()

}

object FileConstants {
    const val folderName = "quizzes_salvos"

}
