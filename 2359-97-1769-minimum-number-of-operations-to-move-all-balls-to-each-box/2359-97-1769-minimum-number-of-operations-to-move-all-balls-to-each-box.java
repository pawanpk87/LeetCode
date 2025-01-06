class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();

        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            int operations = 0;

            for(int j = i - 1; j >= 0; j--) {
                if(boxes.charAt(j) == '1') {
                    operations += (i - j);
                }
            }

            for(int j = i + 1; j < n; j++) {
                if(boxes.charAt(j) == '1') {
                    operations += (j - i);
                }
            }

            ans[i] = operations;
        }

        return ans;
    }
}
/*
    1.) boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.
    
    2.) Box i is adjacent to box j if abs(i - j) == 1.

    3.)  answer[i] is the minimum number of operations needed 
         to move all the balls to the ith box.

    4.) Each answer[i] is calculated considering the 
        initial state of the boxes.


    ex1:
            boxes = "110"

            "110"
            "200" -> 1
            "020" -> 1
            "002" -> 3

    ex2:
            boxes = "001011"

            "001011"

            "300000" -> 1


    Solutions1:-    
            "0 0 1 0 1 1"
             0 1 2 3 4 5
             |
            
            O(N * N)


    Solutions2:

        "0 0 1 0 1 1"
         0 1 2 3 4 5
               |

         0 0 1 1 2 3
         3 3 3 2 2 1
         
*/