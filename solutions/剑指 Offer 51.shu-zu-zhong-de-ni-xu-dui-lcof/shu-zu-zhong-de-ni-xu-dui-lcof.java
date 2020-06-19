

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().reversePairs(new int[]{7, 5, 6, 4}));
    }

    public int reversePairs(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        return reversePairs(nums, 0, nums.length - 1);
    }

    int reversePairs(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int rp = reversePairs(nums, left, mid) + reversePairs(nums, mid + 1, right);
        int[] temp = new int[right - left + 1];
        int l = left, r = mid + 1, k = 0;
        //merge nums[l:mid] and nums[mid+1:right-1];
        while (l <= mid && r <= right) {
            rp += nums[l] <= nums[r] ? r - (mid + 1) : 0;
            temp[k++] = nums[l] <= nums[r] ? nums[l++] : nums[r++];
        }
        while (l <= mid) {
            rp += r - (mid + 1);
            temp[k++] = nums[l++];
        }
        while (r <= right)
            temp[k++] = nums[r++];
        System.arraycopy(temp, 0, nums, left, right - left + 1);
        return rp;
    }
}