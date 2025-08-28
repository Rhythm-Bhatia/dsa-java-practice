class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<>(){
            @Override
            public int compare(int[]a,int[]b){
                return Integer.compare(a[1],b[1]);
            }
        });
        int count=0;
        int LastGreater=Integer.MIN_VALUE;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]>=LastGreater){
                count++;
                LastGreater=intervals[i][1];
            }
            
        }
        return intervals.length-count;
    }
}