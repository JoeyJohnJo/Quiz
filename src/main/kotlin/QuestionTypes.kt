import telas.presentQuiz.showFreeTextAnswerQuestion
import telas.presentQuiz.showMultipleAnswersQuestion
import telas.presentQuiz.showTrueOrFalseQuestion

enum class QuestionTypes(val value: String, val printFunction: (List<*>) -> Boolean) {
    TRUE_OR_FALSE("TRUE_OR_FALSE", ::showTrueOrFalseQuestion),
    MULTIPLE_ANSWERS("MULTIPLE_ANSWERS", ::showMultipleAnswersQuestion),
    FREE_TEXT_ANSWER("FREE_TEXT_ANSWER", ::showFreeTextAnswerQuestion);
}
