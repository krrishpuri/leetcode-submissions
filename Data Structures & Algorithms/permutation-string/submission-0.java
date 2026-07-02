class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[128];

        for (char c : s1.toCharArray()) {
            arr[c]++;
        }

        int left = 0, right = 0;
        int counter = 0;

        char[] s2Arr = s2.toCharArray();

        while (right < s2Arr.length) {
            char c = s2Arr[right];

            if (--arr[c] >= 0) {
                counter++;
            }

            while (counter == s1.length()) {

                // If window length equals s1 length, permutation found
                if (right - left + 1 == s1.length()) {
                    return true;
                }

                char leftChar = s2Arr[left];
                if (++arr[leftChar] > 0) {
                    counter--;
                }
                left++;
            }

            right++;
        }

        return false;
    }
}