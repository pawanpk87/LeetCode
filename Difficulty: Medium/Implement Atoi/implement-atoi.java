//{ Driver Code Starts
// Initial template for JAVA

import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();

            Solution obj = new Solution();
            int num = obj.myAtoi(str);
            System.out.println(num);
            System.out.println("~");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        
        int index = 0;
        long number = 0;
        
        // skip the leading whitespaces
        while(index < n && s.charAt(index) == ' ') {
            index++;
        }
        
        boolean isPositive = true;
        
        // check for sign
        if(s.charAt(index) == '-') {
            isPositive = false;
            index++;
        } else if(s.charAt(index) == '+') {
            index++;
        }
        
        // ignore the leading zeros
        while(index < n && s.charAt(index) == '0') {
            index++;
        }
        
        while(index < n && 
              s.charAt(index) >= '0' &&  s.charAt(index) <= '9') {
            number = number * 10 + (s.charAt(index) - '0');
            index++;
        }
        
        if(!isPositive) {
            number = -1 * number;
        }
        
        if(number > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        
        if(number < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        return (int) number;
    }
}