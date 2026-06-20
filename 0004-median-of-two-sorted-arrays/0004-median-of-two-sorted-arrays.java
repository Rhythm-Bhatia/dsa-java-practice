class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int n1=nums1.length;
        int n2=nums2.length;
        if(n1==0){
            if(n2%2==0){
                int middle=nums2[n2/2]+nums2[(n2-1)/2];
                return middle/2.0;
            }
            else{
                return (double)nums2[n2/2];
            }
        }
        if(n2==0){
            if(n1%2==0){
                int middle=nums1[n1/2]+nums1[(n1-1)/2];
                return middle/2.0;
            }
            else{
                return (double)nums1[n1/2];
            }
        }
        int total=n1+n2;
        int seperation1=0;
        int seperation2=0;
        if(total%2==0){
            seperation1=total/2;
            seperation2=total/2;
        } 
        else{
            seperation1=(total+1)/2;
            seperation2=total/2;
        }
        int low=0;
        int high=nums1.length;
        while(low<=high){
            int mid1=low+(high-low)/2;
            int mid2=seperation1-mid1;
            
            int l1=Integer.MIN_VALUE;
            int r2=Integer.MAX_VALUE;
            int l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE;
            if(mid1!=0)l1=nums1[mid1-1];
            if(mid2!=0)l2=nums2[mid2-1];
            if(mid1!=nums1.length)r1=nums1[mid1];
            if(mid2!=nums2.length) r2 = nums2[mid2];
            if(r1>=l2&&r2>=l1){
                if(total%2==0){
                    int maxleft=Math.max(l1,l2);
                    int minright=Math.min(r1,r2);
                    double ans=(maxleft+minright)/2.0;
                    return ans;
                }
                else{
                    int max=Math.max(l1,l2);
                    return (double)max;
                }
            }
            else if(l2>r1){
                low=mid1+1;
            }
            else{
                high=mid1-1;
            }


        }
        return 0.0;
    }
}