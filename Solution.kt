
import java.util.*

class Solution {

    private companion object {
        const val MIN_LIMIT = 0
    }

    fun minIncrementForUnique(input: IntArray): Int {
        var maxValue = Arrays.stream(input).max().asInt
        var frequency = IntArray(maxValue + 1)
        for (value in input) {
            ++frequency[value];
        }

        var minIncrementCount = 0
        for (value in MIN_LIMIT..<maxValue) {
            if (frequency[value] > 1) {
                minIncrementCount += frequency[value] - 1;
                frequency[value + 1] += frequency[value] - 1;
            }
        }

        return if (frequency[maxValue] > 1) {
            (minIncrementCount + sumAllValuesFromOneToN(frequency[maxValue] - 1))
        } else minIncrementCount;
    }

    private fun sumAllValuesFromOneToN(n: Int): Int {
        return n * (n + 1) / 2;
    }
}
