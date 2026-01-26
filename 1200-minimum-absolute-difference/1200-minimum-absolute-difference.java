class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min_diff=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            int diff=arr[i+1]-arr[i];
            min_diff=Math.min(diff,min_diff);
        }
        List<List<Integer>>list=new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            int diff=arr[i+1]-arr[i];
            if(diff==min_diff){
                ArrayList<Integer>listt=new ArrayList<>();
                listt.add(arr[i]);
                listt.add(arr[i+1]);
                list.add(listt);
            }
            
        }
        return list;

    }
}