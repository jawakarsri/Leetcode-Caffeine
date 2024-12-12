/*
 * @lc app=leetcode id=2558 lang=java
 *
 * [2558] Take Gifts From the Richest Pile
 */

// @lc code=start
class Solution {
    public long pickGifts(int[] gifts, int k) {
        // Use a max heap to always pick the richest pile
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int gift : gifts) {
            maxHeap.add(gift);
        }

        // Perform k operations
        for (int i = 0; i < k; i++) { // Corrected the loop to run k times
            int richestPile = maxHeap.poll();
            int remainingGifts = (int) Math.sqrt(richestPile);
            maxHeap.add(remainingGifts);
        }

        // Sum up all the remaining gifts
        long totalGifts = 0;
        while (!maxHeap.isEmpty()) {
            totalGifts += maxHeap.poll();
        }

        return totalGifts;
    }
}

// Time Complexity: O((n + k) log n)
// - Building the max heap: O(n log n)
// - Performing k operations: O(k log n)
// - Summing up the remaining gifts: O(n log n)

// Space Complexity: O(n)
// - For storing the elements in the max heap
// @lc code=end

