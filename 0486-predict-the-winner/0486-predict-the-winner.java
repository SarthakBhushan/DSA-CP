class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int total =0;
        for(int i=0;i<n;i++){
            total+= nums[i];
        }
        int[][]memo = new int[n][n];
        for(int[]row:memo){
            Arrays.fill(row,-1);
        }
        return memo(0,nums.length-1, memo, nums)>=0;
    }

    public int memo(int l , int r, int[][]memo, int[]nums){
        if(l==r)return nums[l];
        if(memo[l][r]!=-1)return memo[l][r];
        int takeRight = nums[r]- memo(l,r-1,memo,nums);
        int takeLeft = nums[l] - memo(l+1,r,memo,nums);
        return memo[l][r]= Math.max(takeLeft, takeRight);
    }
}