package base

abstract class AbstractConditionModel<M : Number> : ConditionModel<M> {

    override fun isCorrect(number: M): Boolean = condition(number).also { conditionResult ->
        if (conditionResult) {
            onTrigger(number)
        }
    }

    protected abstract fun condition(number: M): Boolean

    protected abstract fun onTrigger(number: M)
}