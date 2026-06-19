public class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.replace("/", "//").replace("|", "/|"));
            sb.append("|");
        }

        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder curr = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '/') {
                curr.append(s.charAt(++i));
            } else if (ch == '|') {
                res.add(curr.toString());
                curr = new StringBuilder();
            } else {
                curr.append(ch);
            }
        }

        return res;
    }
}