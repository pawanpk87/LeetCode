func findNumbers(nums []int) int {
    count := 0

    for _, num := range nums {
        if hasEvenNumbersOfDigits(num) {
            count++;
        }
    }

    return count
}

func hasEvenNumbersOfDigits(num int) bool {
    digitCount := 0

    for num != 0 {
        num = num / 10;
        digitCount++;
    }

    return digitCount%2 == 0
}