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

    private void updateSegmentTree(int i, int l, int r, int index, int val) {
        if (l == r) {
            segmentTree[i] = val;
            return;
        }

        int mid = (l+r)/2;

        if (index <= mid) {
            updateSegmentTree(2*i+1,l,mid,index,val);
        } else {
            updateSegmentTree(2*i+2,mid+1,r,index,val);
        }

        segmentTree[i] = segmentTree[2*i+1] + segmentTree[2*i+2];
    }
    
    public void update(int index, int val) {
        updateSegmentTree(0,0,n-1,index,val);
    }

    private int querySegmentTree(int i, int l, int r, int start, int end) {
        if (l > end || r < start) {
            return 0;
        }

        if (start <= l && r <= end) {
            return segmentTree[i];
        }

        int mid = (l+r)/2;

        int leftHalfSum = querySegmentTree(2*i+1,l,mid,start,end);
        int rightHalfSum = querySegmentTree(2*i+2,mid+1,r,start,end);

        return leftHalfSum + rightHalfSum;

    }
    
    public int sumRange(int left, int right) {
        return querySegmentTree(0,0,n-1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
