class Solution {
public:
    int countStudents(vector<int>& students, vector<int>& sandwiches) {
        int n = students.size();
        queue<int> q;
        for(int i = n-1; i >= 0; i--){
            q.push(students[i]);
        }
        int index = 0, lastServed = 0;
        while(!q.empty() && lastServed < q.size()){
            if(q.front() == sandwiches[index]){
                q.pop();
                index++;
                lastServed = 0;
            }else{
                lastServed++;
                q.push(q.front());
                q.pop();
            }
        }
        return q.size();
    }
};