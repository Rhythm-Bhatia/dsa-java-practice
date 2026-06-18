class Solution {
    public String largestPalindromic(String num) {

        TreeMap<Character, Integer> map =
                new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < num.length(); i++) {
            map.put(num.charAt(i),
                    map.getOrDefault(num.charAt(i), 0) + 1);
        }

        StringBuilder left = new StringBuilder();
        char middle = '#';

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            char key = entry.getKey();
            int value = entry.getValue();

            if (value % 2 == 1 && middle == '#') {
                middle = key;
            }

            int count = value / 2;

            // Skip leading zero pairs
            if (key == '0' && left.length() == 0) {
                continue;
            }

            while (count-- > 0) {
                left.append(key);
            }
        }

        // If no non-zero pair exists
        if (left.length() == 0) {
            if (middle != '#') {
                return String.valueOf(middle);
            }
            return "0";
        }

        StringBuilder right = new StringBuilder(left).reverse();

        StringBuilder ans = new StringBuilder();
        ans.append(left);

        if (middle != '#') {
            ans.append(middle);
        }

        ans.append(right);

        return ans.toString();
    }
}