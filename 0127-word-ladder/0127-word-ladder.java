

class Solution {

    class Pair {
        String first;
        String second;
        int steps;

        Pair(String first, String second, int steps) {
            this.first = first;
            this.second = second;
            this.steps = steps;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        wordList.add(beginWord);

        int n = wordList.size();
        int len = beginWord.length();

        // your adjacency list idea
        List<Pair> adj = new ArrayList<>();

        // make all connections
        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                String a = wordList.get(i);
                String b = wordList.get(j);

                int diff = 0;

                for (int k = 0; k < len; k++) {

                    if (a.charAt(k) != b.charAt(k)) {
                        diff++;
                    }
                }

                // only one character different
                if (diff == 1) {

                    adj.add(new Pair(a, b, 0));
                    adj.add(new Pair(b, a, 0));
                }
            }
        }

        // BFS
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        visited.add(beginWord);

        // add all neighbors of beginWord
        for (int i = 0; i < adj.size(); i++) {

            Pair p = adj.get(i);

            if (p.first.equals(beginWord)) {

                visited.add(p.second);
                q.offer(new Pair(p.first, p.second, 1));
            }
        }

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            String a = curr.first;
            String b = curr.second;
            int steps = curr.steps;

            // found answer
            if (b.equals(endWord)) {
                return steps + 1;
            }

            // iterate entire adjacency list
            for (int i = 0; i < adj.size(); i++) {

                Pair p = adj.get(i);

                // neighbor of current node
                if (b.equals(p.first)) {

                    if (!visited.contains(p.second)) {

                        visited.add(p.second);

                        q.offer(new Pair(
                            p.first,
                            p.second,
                            steps + 1
                        ));
                    }
                }
            }
        }

        return 0;
    }
}