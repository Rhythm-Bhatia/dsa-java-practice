class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();

        solve(s, set, 0, "", result);

        return result;
    }

    private void solve(String s, Set<String> set, int index,
                       String temp, List<String> result) {

        // Base case
        if (index == s.length()) {
            result.add(temp.trim()); // remove extra space
            return;
        }

        for (int i = index + 1; i <= s.length(); i++) {

            String part = s.substring(index, i);

            if (set.contains(part)) {

                // TAKE
                solve(s, set, i, temp + part + " ", result);
            }
        }
    }
}