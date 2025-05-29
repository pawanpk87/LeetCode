/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func goodNodesUtil(root *TreeNode, maxNum int) int {
    if root == nil {
        return 0
    }

    count := 0

    if root.Val >= maxNum {
        count++
    }

    count += goodNodesUtil(root.Left, max(root.Val, maxNum))
    count += goodNodesUtil(root.Right, max(root.Val, maxNum))

    return count;
}

func goodNodes(root *TreeNode) int {
    return goodNodesUtil(root, math.MinInt)
}