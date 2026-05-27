class Solution {
    public int trap(int[] height) {
         int l=0;
         int r=height.length-1;
         int lmax=height[l];
         int rmax=height[r];
         int ans=0;
         while(l<r){
            if(height[l]>height[r]){
                rmax=Math.max(rmax,height[r]);
                ans+=rmax-height[r];
                r--;
            }
            else{
                lmax=Math.max(height[l],lmax);
                ans+=lmax-height[l];
                l++;
            }
        }
         return ans;
    }
}