class Solution {
    public String largestPalindromic(String num) {

        TreeMap<Character, Integer> map =
                new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < num.length(); i++) {
            map.put(num.charAt(i),
                    map.getOrDefault(num.charAt(i), 0) + 1);
        }

        StringBuilder left = new StringBuilder();
        char max = '#';

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            char key = entry.getKey();
            int value = entry.getValue();

            if (value % 2 != 0 && max == '#') {
                max = key;
            }

            int count = value / 2;

            while (count-- > 0) {
                left.append(key);
            }
        }

        StringBuilder right = new StringBuilder(left).reverse();

        StringBuilder ans = new StringBuilder(left);

        if (max != '#') {
            ans.append(max);
        }

        ans.append(right);

        int i = 0;
        int j = ans.length() - 1;

        while (i < j &&
              (ans.charAt(i) == '0' || ans.charAt(j) == '0')) {

            if (ans.charAt(i) == '0') i++;
            if (ans.charAt(j) == '0') j--;
        }

        if (i > j) {
            return "0";
        }

        String res = ans.substring(i, j + 1);

        return res.isEmpty() ? "0" : res;
    }
}