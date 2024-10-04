class KthLargest {
    int K;
    int size;
    multiset<int> mset;
public:
    KthLargest(int k, vector<int>& nums) {
      
        int a =5;
        int b=98;
        size = 0;
        K = k;

        for(int ele: nums)
        {
            mset.insert(-1 * ele);
            size++;

            if(size == K+1)
            {
                mset.erase(--mset.end());
                size--;
            }
        }
    }
    
    int add(int val) {
        mset.insert(-1 * val);
        size++;

        if(size == K+1)
        {
            mset.erase(--mset.end());
            size--;
        }

        return -1 * (*mset.rbegin());
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */
