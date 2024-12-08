
/*
 * @lc app=leetcode id=2054 lang=java
 *
 * [2054] Two Best Non-Overlapping Events
 */

// @lc code=start
public class Solution {
    public int maxTwoEvents(int[][] events) {
        // Step 1: Sort events by their end times
        Arrays.sort(events, (a, b) -> a[1] - b[1]);

        // Step 2: Initialize an array to store the maximum value up to each event
        int n = events.length;
        int[] maxValues = new int[n];
        maxValues[0] = events[0][2];

        // Step 3: Fill the maxValues array
        for (int i = 1; i < n; i++) {
            maxValues[i] = Math.max(maxValues[i - 1], events[i][2]);
        }

        int maxSum = 0;

        // Step 4: Iterate through each event and find the best non-overlapping event
        for (int i = 0; i < n; i++) {
            int currentEventValue = events[i][2];
            int latestNonOverlappingIndex = binarySearch(events, events[i][0]);
            int maxNonOverlappingValue = (latestNonOverlappingIndex >= 0) ? maxValues[latestNonOverlappingIndex] : 0;
            maxSum = Math.max(maxSum, currentEventValue + maxNonOverlappingValue);
        }

        return maxSum;
    }

    // Binary search to find the latest event that ends before the target start time
    private int binarySearch(int[][] events, int target) {
        int left = 0, right = events.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][1] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
/*Time Complexity
Sorting the events takes (O(n \log n)).
Filling the maxValues array takes (O(n)).
For each event, performing a binary search takes (O(\log n)), and since we do this for each event, it takes (O(n \log n)) in total.
Overall time complexity: (O(n \log n)).
Space Complexity
The space complexity is (O(n)) due to the maxValues array and the input array.
This approach ensures that we efficiently find the two best non-overlapping events with optimal time and space complexity. */
// @lc code=end

