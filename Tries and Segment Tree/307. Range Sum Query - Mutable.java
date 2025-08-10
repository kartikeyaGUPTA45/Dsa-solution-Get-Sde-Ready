class NumArray {
    int segmentTree[];
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        segmentTree = new int[4*n];
        buildTree(0,0,n-1,nums);
    }

    private void buildTree(int i, int l, int r, int nums[]) {
        if (l == r) {
            segmentTree[i] = nums[l];
            return;
        }

        int mid = (l+r)/2;

        buildTree(2*i+1,l,mid,nums);
        buildTree(2*i+2,mid+1,r,nums);

        segmentTree[i] = segmentTree[2*i+1] + segmentTree[2*i+2];
    }
    
    public void update(int index, int val) {
        nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i=left;i<=right;i++) {
            sum += nums[i];
        }

        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
