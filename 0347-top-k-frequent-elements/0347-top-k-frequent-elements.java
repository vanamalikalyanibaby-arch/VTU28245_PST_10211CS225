import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency of each number
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a max heap based on frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );

        // Add all numbers to heap
        pq.addAll(map.keySet());

        // Step 3: Take k most frequent elements
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}