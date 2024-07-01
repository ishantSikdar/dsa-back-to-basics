public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        int target = 10;

        System.out.println(binarySearch(nums, target));

    }

    public static int binarySearch(int nums[], int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;

            } else if (nums[mid] > target) {
                end = mid - 1;

            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }

        return -1;
    }

}