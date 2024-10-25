class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> allPaths = new HashSet<>(Arrays.asList(folder));
        
        List<String> allFolders = new ArrayList<>();
        
        for(String path : folder) {
            boolean isSubFolder = false;
            String tempPath = path;
            
            while(!tempPath.isEmpty()) {
                int pos = tempPath.lastIndexOf('/');

                if(pos == -1) {
                    break;
                }

                tempPath = tempPath.substring(0, pos);
                
                if(allPaths.contains(tempPath)) {
                    isSubFolder = true;
                    break;
                }
            }
            
            if(!isSubFolder) {
                allFolders.add(path);
            }
        }
        
        return allFolders;
    }
}