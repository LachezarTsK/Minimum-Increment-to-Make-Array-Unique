
function minIncrementForUnique(input: number[]): number {
    const MIN_LIMIT = 0;
    let maxValue = Math.max(...input);
    const frequency: number[] = new Array(maxValue + 1).fill(0);
    for (let value of input) {
        ++frequency[value];
    }

    let minIncrementCount = 0;
    for (let value = MIN_LIMIT; value < maxValue; ++value) {
        if (frequency[value] > 1) {
            minIncrementCount += frequency[value] - 1;
            frequency[value + 1] += frequency[value] - 1;
        }
    }

    return (frequency[maxValue] > 1)
            ? (minIncrementCount + sumAllValuesFromOneToN(frequency[maxValue] - 1))
            : minIncrementCount;
};

function sumAllValuesFromOneToN(n: number): number {
    return n * (n + 1) / 2;
}
