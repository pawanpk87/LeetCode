
class SegmentTree{
private:
    int n;
    vector<int> tree;
public:
    SegmentTree(vector<int>& nums){
        this->n = nums.size();
        tree.resize(4 * this->n);
        buildTree(nums, 1, 0, this->n-1);
    }

    void buildTree(vector<int>& nums, int v, int tl, int tr){
        if(tl == tr){
            tree[v] = nums[tl];
        } else{
            int tm = (tl + tr) / 2;
            buildTree(nums, 2*v, tl, tm);
            buildTree(nums, 2*v+1, tm+1, tr);
            tree[v] = tree[2*v] + tree[2*v + 1];
        }
    }

    int sum(int v, int tl, int tr, int l, int r){
        if(l > r){
            return 0;
        }
        if(tl == l && tr == r){
            return tree[v];
        }
        int tm = (tl + tr)/2;
        return sum(2*v, tl, tm, l, min(tm, r)) + 
               sum(2*v + 1, tm+1, tr, max(tm+1, l), r);
    }

    void update(int v, int tl, int tr, int pos, int val){
        if(tl == tr){
            tree[v] = val;
        } else{
            int tm = (tl + tr)/2;
            if(pos <= tm){
                update(2*v, tl, tm, pos, val);
            } else{
                update(2*v + 1, tm+1, tr, pos, val);
            }
            tree[v] = tree[2*v] + tree[2*v + 1];
        }
    }
};

class NumArray {
private:
    SegmentTree* st;
    int n;
public:
    NumArray(vector<int>& nums) {
        this->n = nums.size();
        this->st = new SegmentTree(nums);
    }
    
    void update(int index, int val) {
        st->update(1, 0, n-1, index, val);
    }
    
    int sumRange(int left, int right) {
        return st->sum(1, 0, n-1, left, right);
    }
};