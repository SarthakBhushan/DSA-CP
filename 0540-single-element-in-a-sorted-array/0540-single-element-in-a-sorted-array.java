class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == 0) {
                if (nums[mid] != nums[mid + 1]) return nums[mid];
            }
            if (mid == n - 1) {
                if (nums[mid] != nums[mid - 1]) return nums[mid];
            }
            if (nums[mid] != nums[mid + 1] &&
                nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[mid] == nums[mid - 1]) {
                if ((mid - left) % 2 == 0) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else {
                if ((right - mid) % 2 == 0) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}