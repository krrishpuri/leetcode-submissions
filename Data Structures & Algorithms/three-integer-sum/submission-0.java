

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> outputArr = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate first elements
            if (i == 0 || nums[i] != nums[i - 1]) {

                int low = i + 1;
                int high = nums.length - 1;
                int target = -nums[i];

                while (low < high) {

                    int currentSum = nums[low] + nums[high];

                    if (currentSum == target) {

                        outputArr.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        // Skip duplicates
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }

                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }

                        low++;
                        high--;

                    } else if (currentSum > target) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }

        return outputArr;
    }
}
