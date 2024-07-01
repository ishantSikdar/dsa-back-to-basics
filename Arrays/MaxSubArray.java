public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = { -2, -3, -4, -2, -2, -2, -5, -3 };

        // int sum = bruteForce(nums);
        int sum = prefixSum(nums);
        // int sum = kadanesAlgo(nums);
        System.out.println("Max SubArray Sum: " + sum);
    }

    private static int kadanesAlgo(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        int greatestNegative = Integer.MIN_VALUE;
        boolean isPositivePresent = false;

        for (int i = 0; i < arr.length; i++) {
            isPositivePresent = arr[i] > 0;

            currSum = arr[i] + currSum;

            if (currSum < 0) {
                currSum = 0;
            }

            maxSum = Math.max(currSum, maxSum);
            greatestNegative = Math.max(greatestNegative, arr[i]);
        }

        if (!isPositivePresent) {
            return greatestNegative;
        } else {
            return maxSum;
        }
    }

    private static int bruteForce(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int scopeSum = 0;
                for (int k = i; k <= j; k++) {
                    scopeSum += nums[k];
                }
                // System.out.println("Sum: " + scopeSum);
                max = Math.max(max, scopeSum);
            }
        }

        return max;
    }

    private static int prefixSum(int[] arr) {
        int maxSubArray = Integer.MIN_VALUE;
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = arr[i] + prefixSum[i - 1];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int subArrSum = i == 0 ? prefixSum[j] : prefixSum[j] - prefixSum[i - 1];
                // System.out.println("Arr from " + arr[i] + " to " + arr[j] + " is " +
                // subArrSum);
                maxSubArray = Math.max(subArrSum, maxSubArray);
            }
        }

        return maxSubArray;
    }
}
