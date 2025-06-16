func maximumDifference(nums []int) int {
    n := len(nums)

    maxDiff := -1
    minNum := nums[0]

    for j := 1; j < n; j++ {
        if minNum < nums[j] {
            diff := nums[j] - minNum
            if diff > maxDiff {
                maxDiff = diff
            }
        }
        if nums[j] < minNum {
            minNum = nums[j]
        }
    }

    return maxDiff
}