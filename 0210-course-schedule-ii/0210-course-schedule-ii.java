import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Step 1: Create adjacency list
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        // Step 2: Build graph (b → a)
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            list.get(u).add(v);
        }

        // Step 3: Compute indegree
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for (int neighbor : list.get(i)) {
                indegree[neighbor]++;
            }
        }

        // Step 4: Queue for nodes with indegree 0
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 5: Kahn's Algorithm + store order
        int[] result = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[index++] = node;

            for (int neighbor : list.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Step 6: If cycle exists → return empty array
        if (index != numCourses) {
            return new int[0];
        }

        return result;
    }
}