class Solution {

    public int minOperations(int[][] grid, int x) {
        List<Integer> list = getList(grid);

        Collections.sort(list);

        int n = list.size();

        if(n == 1) {
            return 0;
        }

        int baseNum1 = list.get(n/2);
        int baseNum2 = list.get(n/2 - 1);
            
        return Math.min(countOperations(list, baseNum1, x),
                        countOperations(list, baseNum2, x));
    }

    private int countOperations(List<Integer> list, int baseNum, int x) {
        int count = 0;

        for(int num : list) {
            int rem = Math.abs(baseNum - num);

            if(rem % x != 0) {
                return -1;
            }
            
            count += rem/x;
        }

        return count;
    }

    private List<Integer> getList(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr.add(grid[i][j]);
            }
        }

        return arr;
    }
}
/*

    Note:
        1.) A uni-value grid is a grid where all the elements of it are equal.
        2.) Return the minimum number of operations to make the grid uni-value.
        3.)  In one operation, you can add x to or subtract x from any element in the grid.

    Q:
        1.) always possible?

    Approach:

        grid = [[1,2],[3,4]], x = 2

        1 2 3 4
          |
        +1 -1-2

        but there is limit on how much we can inc/dec
            i.e x

        1 2 3 4
          |
        +1 -1-2
        /x

        count = 1+1+3

    is it possible to try diffent number apart from middle num
        if in the case of imppossible case?


        1 6 12 34 56    x
            |
        
        res: not possible

        try diff num like num = 6


    grid = [[1,2],[3,4]], x = 2

    2 4 5 8

    collect the elements from the grid
    
    sort the arr
    
    baseNum :- take the middle element as base element/num

    iterate through each element
        -> for each element/num
            rem = abs(num - baseNum)
        
            if ! rem % x 
                return - 1

            count += rem/x

    return count
*/