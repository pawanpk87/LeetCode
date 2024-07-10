class Solution {
    public int minOperations(String[] logs) {
        int folderCount = 0;
        for(String log : logs){
            if("../".equals(log)) {
                if(folderCount > 0){
                    folderCount--;
                }
            } else if("./".equals(log)) {
                // do nothing
            } else {
                folderCount++;
            }
        }
        return folderCount;
    }
}