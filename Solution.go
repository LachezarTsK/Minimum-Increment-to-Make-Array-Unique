
package main

import (
    "fmt"
    "slices"
)

var MIN_LIMIT = 0

func minIncrementForUnique(input []int) int {
    maxValue := slices.Max(input)
    var frequency = make([]int, maxValue+1)
    for _, value := range input {
        frequency[value]++
    }

    var minIncrementCount = 0
    for value := MIN_LIMIT; value < maxValue; value++ {
        if frequency[value] > 1 {
            minIncrementCount += frequency[value] - 1
            frequency[value+1] += frequency[value] - 1
        }
    }

    return Ternary(frequency[maxValue] > 1,
                   minIncrementCount+sumAllValuesFromOneToN(frequency[maxValue]-1),
                   minIncrementCount)

}

func sumAllValuesFromOneToN(n int) int {
    return n * (n + 1) / 2
}

func Ternary[T any](condition bool, first T, second T) T {
    if condition {
        return first
    }
    return second
}
