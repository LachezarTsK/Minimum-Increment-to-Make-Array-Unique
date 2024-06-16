
import java.util.Arrays;

public class Solution {

    private static final int MIN_LIMIT = 0;

    public int minIncrementForUnique(int[] input) {
        int maxValue = Arrays.stream(input).max().getAsInt();
        int[] frequency = new int[maxValue + 1];
        for (int value : input) {
            ++frequency[value];
        }

        int minIncrementCount = 0;
        for (int value = MIN_LIMIT; value < maxValue; ++value) {
            if (frequency[value] > 1) {
                minIncrementCount += frequency[value] - 1;
                frequency[value + 1] += frequency[value] - 1;
            }
        }

        return (frequency[maxValue] > 1)
                ? (minIncrementCount + sumAllValuesFromOneToN(frequency[maxValue] - 1))
                : minIncrementCount;
    }

    private int sumAllValuesFromOneToN(int n) {
        return n * (n + 1) / 2;
    }
}
