class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0;
        int n = nums.length;
        for(int r=0;r<nums.length;r++){
            if(nums[r]==0){
                k--;
            }
            if(k<0){
                if(nums[l]==0){
                    k++;
                }
                l++;
            }
        }
        return n-l;
    }
}