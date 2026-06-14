class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low=1;
        int high=position[position.length-1];
        int ans=0;
        while(high>=low){
            int mid=(high+low)/2;
            if(check(mid,position,m)==true){
                low=mid+1;
                ans=mid;
            }
            else{
                high=mid-1;
            }
        }
        return ans;
    }
    private boolean check(int mid,int[]position,int m){
        int count=1;
        int last=position[0];
        for(int i=1;i<position.length;i++){
            if(position[i]-last>=mid){
                count++;
                last=position[i];
                if(count==m){
                    break;
                }
            }
            else{
                continue;
            }
        }
        if(count==m)return true;
        return false;
    }
}