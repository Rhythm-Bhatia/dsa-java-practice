class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean added = false;

        for (int i = 0; i < intervals.length; i++) {
            if (!added && newInterval[0] < intervals[i][0]) {
                list.add(new int[]{newInterval[0], newInterval[1]});
                added = true;
            }
            list.add(new int[]{intervals[i][0], intervals[i][1]});
        }

        if (!added) {
            list.add(new int[]{newInterval[0], newInterval[1]});
        }

        List<int[]> merged = new ArrayList<>();
        int prevMax = -1;

        for (int i = 0; i < list.size(); i++) {
            int start = list.get(i)[0];
            int end = list.get(i)[1];

            if (start > prevMax) {
                merged.add(new int[]{start, end});
                prevMax = end;
            } else {
                int lastIndex = merged.size() - 1;
                merged.get(lastIndex)[1] = Math.max(merged.get(lastIndex)[1], end);
                prevMax = merged.get(lastIndex)[1];
            }
        }

        int[][] result = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i);
        }
        return result;
    }
}
