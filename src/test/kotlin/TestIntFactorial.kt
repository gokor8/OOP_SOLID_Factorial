import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class TestIntFactorial {

    val intConditionModel = IntConditionModel()
    val intFactorialModel = FactorialModelInt()

    val factorial = Factorial(intConditionModel, intFactorialModel)

    @Test
    fun `test factorial with 3 success`() {
        val actual = factorial.factorial(3)
        val expected = 6

        assertEquals(actual, expected)
    }

    @Test
    fun `test factorial with 0 error`() {
        assertThrows<IllegalStateException> {
            factorial.factorial(0)
        }
    }

    @Test
    fun `test factorial with 15 over value error`() {
        assertThrows<IllegalStateException> {
            factorial.factorial(15)
        }
    }

    @Test
    fun `test factorial with -1 negative value error`() {
        assertThrows<IllegalStateException> {
            factorial.factorial(-1)
        }
    }
}