
public class Solution {  // Renamed class to Solution
    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i <= pattern.length(); i++) {
            stack.push(i + 1); // Push numbers from 1 to n+1
            
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.smallestNumber("IIIDIDDD")); // Output: "123549876"
        System.out.println(sol.smallestNumber("DDD"));      // Output: "4321"
    }
}