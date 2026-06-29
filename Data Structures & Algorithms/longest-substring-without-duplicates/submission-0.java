//

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int a_pointer = 0;
        int b_pointer = 0;
        int max = 0;

        HashSet<Character> hash_set = new HashSet<>();

        while (b_pointer < s.length()) {
            if (!hash_set.contains(s.charAt(b_pointer))) {
                hash_set.add(s.charAt(b_pointer));
                max = Math.max(max, b_pointer - a_pointer + 1);
                b_pointer++;
            } else {
                hash_set.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }

        return max;
    }
}
