
using System;
using System.Linq;

public class Solution
{
    private static readonly int MIN_LIMIT = 0;
    public int MinIncrementForUnique(int[] input)
    {
        int maxValue = Enumerable.Max(input);
        int[] frequency = new int[maxValue + 1];
        foreach (int value in input)
        {
            ++frequency[value];
        }

        int minIncrementCount = 0;
        for (int value = MIN_LIMIT; value < maxValue; ++value)
        {
            if (frequency[value] > 1)
            {
                minIncrementCount += frequency[value] - 1;
                frequency[value + 1] += frequency[value] - 1;
            }
        }

        return (frequency[maxValue] > 1)
                ? (minIncrementCount + sumAllValuesFromOneToN(frequency[maxValue] - 1))
                : minIncrementCount;
    }

    private int sumAllValuesFromOneToN(int n)
    {
        return n * (n + 1) / 2;
    }
}
