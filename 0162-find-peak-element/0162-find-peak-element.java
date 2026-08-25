class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1)return 0;
        int left =0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left + (right -left)/2;
            if(mid==0){
                if(nums[mid]>nums[mid+1])return mid;
                else left = mid+1;
            }
            else if(mid==nums.length-1){
                if(nums[mid]>nums[mid-1])return mid;
                else right = mid-1;
            }
            else if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1])return mid;
            else if(nums[mid]<nums[mid+1]){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return -1;
    }
}