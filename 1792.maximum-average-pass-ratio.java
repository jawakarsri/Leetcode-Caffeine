/*
 * @lc app=leetcode id=1792 lang=java
 *
 * [1792] Maximum Average Pass Ratio
 */

import java.util.PriorityQueue;

// @lc code=start
class Solution {
    /**
     * This method calculates the maximum average pass ratio after adding extra students.
     * 
     * Approach:
     * 1. Use a max-heap (priority queue) to always add a student to the class that will 
     *    increase the average pass ratio the most.
     * 2. For each class, calculate the initial improvement in pass ratio if one student is added.
     * 3. Add the calculated improvement along with the current pass and total students to the heap.
     * 4. While there are extra students, poll the class with the highest improvement, add a student,
     *    and push the updated class back to the heap with the new improvement.
     * 5. Finally, calculate the total average pass ratio.
     * 
     * Time Complexity: O((n + extraStudents) log n), where n is the number of classes.
     * Space Complexity: O(n), for storing the classes in the priority queue.
     */
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        
        // Calculate initial improvement for each class and add to the heap
        for (int[] c : classes) {
            double pass = c[0], total = c[1];
            pq.offer(new double[]{(pass + 1) / (total + 1) - pass / total, pass, total});
        }
        
        // Distribute extra students to maximize the average pass ratio
        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            double pass = top[1], total = top[2];
            pq.offer(new double[]{(pass + 2) / (total + 2) - (pass + 1) / (total + 1), pass + 1, total + 1});
        }
        
        // Calculate the final average pass ratio
        double result = 0;
        while (!pq.isEmpty()) {
            double[] top = pq.poll();
            result += top[1] / top[2];
        }
        
        return result / classes.length;
    }
}
// @lc code=end

