class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=1;
        int high=0;
        int ans=Integer.MAX_VALUE;
        
        for(int i=0;i<weights.length;i++){
            high+=weights[i];
        }
        while(low<=high){
            int mid=(low+high)/2;
            int temp=mid;
            int tempdays=days-1;
            for(int i=0;i<weights.length;i++){
                if(weights[i]>mid){
                    tempdays=-1;
                    break;
                }
                if(temp-weights[i]<0){
                    temp=mid;
                    tempdays--;
                    temp-=weights[i];
                }
                else{
                    temp=temp-weights[i];
                }
            }
            if(tempdays>=0){
                ans=Math.min(ans,mid);
                high=mid-1;

            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}