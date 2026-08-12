class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int l =0;
        int maxLen =0;
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            while(map.get(nums[l])>k){
                map.put(nums[l], map.get(nums[l])-1);
                l++;
            }
            maxLen = Math.max(i-l+1, maxLen);
        }
        return maxLen;
    }
}