package base

interface FactorialModel<M : Number> {

    fun minusOne(number: M): M

    fun multiple(multiplyValue: M, forMultipleValue: M): M
}