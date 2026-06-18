class Solution {
    public String largestPalindromic(String num) {

        TreeMap<Character, Integer> map =
                new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < num.length(); i++) {
            map.put(num.charAt(i),
                    map.getOrDefault(num.charAt(i), 0) + 1);
        }

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        char max = '#';

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            char key = entry.getKey();
            int value = entry.getValue();

            if (value % 2 != 0 && max == '#') {
                max = key;
            }

            int count = value / 2;

            while (count != 0) {
                str1.append(key);
                str2.insert(0, key);   // same as your key + str2
                count--;
            }
        }

        if (max != '#') {
            str1.append(max);
        }

        str1.append(str2);

        String ans = str1.toString();

        if (ans.isEmpty()) {
            return "0";
        }

        int i = 0;
        int j = ans.length() - 1;

        while (j > i &&
              (ans.charAt(i) == '0' || ans.charAt(j) == '0')) {

            if (ans.charAt(i) == '0') {
                i++;
            }

            if (ans.charAt(j) == '0') {
                j--;
            }
        }

        if (i > j) {
            return "0";
        }

        ans = ans.substring(i, j + 1);

        if (ans.isEmpty()) {
            return "0";
        }

        return ans;
    }
}