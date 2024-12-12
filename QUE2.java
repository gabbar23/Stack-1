// Time Complexity (TC): O(n), where n is the length of the nums array, since each index is processed at most twice during the circular traversal.
// Space Complexity (SC): O(n) for the stack used to store indices.

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // Stack to keep track of indices whose next greater element is not yet found
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        // Result array initialized with -1 (default value for elements with no next
        // greater element)
        int[] res = new int[n];
        Arrays.fill(res, -1);

        // Iterate through the array twice to handle the circular nature of the problem
        for (int i = 0; i < n; i++) {
            int idx = i;// Get the index in the range [0, n-1] to simulate circular traversal

            // Check if the current element is greater than the element at the index on the
            // top of the stack
            while (!stack.isEmpty() && nums[idx] < nums[stack.peek()]) {
                // Update result for the index stored at the top of the stack
                res[stack.pop()] = nums[idx];
            }

            // Push the current index onto the stack only during the first traversal

            stack.push(idx);

        }
        return res;
    }
}