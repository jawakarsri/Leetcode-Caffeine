/*
 * @lc app=leetcode id=2079 lang=java
 *
 * [2079] Watering Plants
 */

// @lc code=start
class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int steps = 0; // Total steps taken
        int currentCapacity = capacity; // Remaining water in the can
        
        for (int i = 0; i < plants.length; i++) {
            // Check if there's enough water to water the current plant
            if (currentCapacity >= plants[i]) {
                // Water the plant
                currentCapacity -= plants[i];
                steps++; // Move to the next plant
            } else {
                // Refill the can: Go back to the river and return to the current plant
                steps += (i * 2); // Steps to go back and return to the current plant
                currentCapacity = capacity - plants[i]; // Refill and water the current plant
                steps++; // Move to the next plant
            }
        }
        
        return steps; // Return the total number of steps
    }
}
// @lc code=end

