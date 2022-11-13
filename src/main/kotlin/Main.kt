import base.AbstractConditionModel
import base.AbstractFactorial
import base.ConditionModel
import base.FactorialModel
import java.lang.IllegalStateException

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

open class IntConditionModel : AbstractConditionModel<Int>() {

    override val stopValue: Int = 1
    // Можно навалить еще стейтов для полного кайфа
    override fun condition(number: Int): Boolean = number < 1 || number > 13

    override fun onTrigger(number: Int) {
        throw IllegalStateException("Invalid number range")
    }
}

open class FactorialModelInt : FactorialModel<Int> {

    override fun minusOne(number: Int) = number - 1

    override fun multiple(multiplyValue: Int, forMultipleValue: Int) = multiplyValue * forMultipleValue

}

open class Factorial<M : Number, CM : ConditionModel<M>, FM : FactorialModel<M>>(
    override val conditionModel: CM,
    override val factorialModel: FM
) : AbstractFactorial<M, CM, FM>() {

    override fun factorial(value: M): M {
        if (value == conditionModel.stopValue) {
            return value
        }

        conditionModel.isCorrect(value)

        return getFactorial(value)
    }
}