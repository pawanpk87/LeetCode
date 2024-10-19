class Solution {
    public char findKthBit(int n, int k) {
        if(k == 1) {
            return '0';
        }
        
        StringBuilder sb = new StringBuilder("0");
        
        while(--n > 0) {
            String orgStr = sb.toString();
            sb.append("1").append(reverse(invert(orgStr)));
            if(sb.length() > k) {
                break;
            }
        }
        
        System.out.println(sb.toString());
        
        return sb.charAt(k - 1);
    }
    
    private String invert(String str) {
        int n = str.length();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++) {
            sb.append(str.charAt(i) == '0' ? '1' : '0');
        }
        
        return sb.toString();
    }
    
    private String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
