class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return solve(nums,k) - solve(nums,k-1);
    }
    public int solve(int[]nums, int k){
        int l =0, count=0;
        for(int r=0;r<nums.length;r++){
            if(k<0)return 0;
            if(nums[r]%2!=0 )k--;
            while(k<0){
                if(nums[l]%2!=0){
                    k++;
                }
                l++;
            }
            count += r-l+1;
        }
        return count;
    }
}