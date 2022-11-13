package base

interface ConditionModel<M : Number> {
    val stopValue: M

    fun isCorrect(number: M): Boolean
}