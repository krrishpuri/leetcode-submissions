class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = t.length();
        int min = Integer.MAX_VALUE;
        int start = 0;

        int i = 0, j = 0;

        while (j < s.length()) {

            char ch = s.charAt(j);

            if (map.containsKey(ch)) {
                if (map.get(ch) > 0)
                    count--;

                map.put(ch, map.get(ch) - 1);
            }

            while (count == 0) {

                if (j - i + 1 < min) {
                    min = j - i + 1;
                    start = i;
                }

                char left = s.charAt(i);

                if (map.containsKey(left)) {
                    map.put(left, map.get(left) + 1);

                    if (map.get(left) > 0)
                        count++;
                }

                i++;
            }

            j++;
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}
