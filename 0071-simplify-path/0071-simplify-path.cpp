class Solution {
public:
    string simplifyPath(string path) {
        vector<string> files;
        stringstream ss(path);
        string currFile;
        
        while(getline(ss,currFile,'/')){
            if(currFile == "" || currFile == ".")
                continue;
            else if(currFile == ".." && files.size() > 0)
                files.pop_back();
            else if(currFile != "..")
                files.push_back(currFile);
        }
        
        string result = "";
        
        for(string file : files){
            result +="/"+file;
        }
        
        return result.size() == 0 ? "/" : result;       
    }
};