// Time Complexity (TC): O(n), where n is the length of the temperatures array, because each index is pushed and popped from the stack at most once.
// Space Complexity (SC): O(n) for the stack used to store indices.

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Stack to store indices of the temperatures array
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        
        // Result array to store the number of days until a warmer temperature
        int[] result = new int[n];
        
        // Iterate through the temperatures array
        for (int i = 0; i < n; i++) {
            // While the stack is not empty and the current temperature is higher than the temperature at the index stored at the top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                // Pop the index from the stack (this is a day with a lower temperature)
                int poppedIdx = stack.pop();
                
                // Calculate the number of days until a warmer temperature and store it in the result array
                result[poppedIdx] = i - poppedIdx;
            }
            
            // Push the current index onto the stack
            stack.push(i);
        }
        
        // Return the result array
        return result;
    }
}
