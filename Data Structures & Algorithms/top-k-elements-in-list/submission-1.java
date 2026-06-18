

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        // Count frequencies
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Bucket array: index = frequency
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(num);
        }

        int[] result = new int[k];
        int idx = 0;

        // Traverse buckets from highest frequency to lowest
        for (int freq = buckets.length - 1; freq >= 0 && idx < k; freq--) {
            if (buckets[freq] == null) {
                continue;
            }

            for (int num : buckets[freq]) {
                result[idx++] = num;

                if (idx == k) {
                    return result;
                }
            }
        }

        return result;
    }
}