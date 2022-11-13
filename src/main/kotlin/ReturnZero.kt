import base.ConditionModel
import base.FactorialModel

interface ReturnZero<M : Number> {
    val zeroValue: M
}

interface ComboConditionModel<M : Number> : ConditionModel<M>, ReturnZero<M>

class StopValueConditionModel : IntConditionModel(), ComboConditionModel<Int> {
    override val zeroValue: Int = 0
}

class ZeroCheckFactorial<M : Number>(
    conditionModel: ComboConditionModel<M>,
    factorialModel: FactorialModel<M>
) : Factorial<M, ComboConditionModel<M>, FactorialModel<M>>(conditionModel, factorialModel) {

    override fun factorial(value: M): M {
        if (conditionModel.zeroValue == value) {
            return conditionModel.zeroValue
        }

        return super.factorial(value)
    }
}