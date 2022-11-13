package base

abstract class AbstractFactorial<M : Number, CM : ConditionModel<M>, FM : FactorialModel<M>> : Factorial<M> {

    protected abstract val conditionModel: CM
    protected abstract val factorialModel: FM

    protected fun getFactorial(value: M) = factorialModel.multiple(
        value,
        factorial(
            factorialModel.minusOne(value)
        )
    )
}