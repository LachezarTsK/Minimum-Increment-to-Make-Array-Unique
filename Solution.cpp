
#include <vector>
using namespace std;

class Solution {

    static const int MIN_LIMIT = 0;

public:
    int minIncrementForUnique(const vector<int>& input) const {
        int maxValue = *ranges::max_element(input);
        vector<int> frequency(maxValue + 1);
        for (const auto& value : input) {
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

private:
    int sumAllValuesFromOneToN(int n) const {
        return n * (n + 1) / 2;
    }
};
