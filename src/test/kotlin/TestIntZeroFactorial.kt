import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class TestIntZeroFactorial {

    val intConditionModel = StopValueConditionModel()
    val intFactorialModel = FactorialModelInt()

    val factorial = ZeroCheckFactorial(intConditionModel, intFactorialModel)

    @Test
    fun `test factorial with 3 success`() {
        val actual = factorial.factorial(3)
        val expected = 6

        assertEquals(actual, expected)
    }

    @Test
    fun `test factorial with 0 error`() {
        val actual = factorial.factorial(0)
        val expected = 0

        assertEquals(expected, actual)
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