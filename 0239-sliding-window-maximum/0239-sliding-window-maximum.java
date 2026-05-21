class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int i=0;
        int j=0;
        int max=0;
        int point=0;
        int arr[]=new int[n-k+1];
        while(j<n){
            if(nums[j]>max){
                max=nums[j];
                i=j;

            }
            if(j-i<k&&j>=k-1){
                arr[point]=max;
                point++;
            }
            else if(j-i>=k){
                if(nums[j]>nums[i]){
                    max=arr[j];
                    i=j;
                    arr[point]=max;
                    point++;
                }
                else{
                    max=nums[j];
                    int x=i+1;
                    for(int a=x;a<=j;a++){
                        if(nums[a]>=max){
                            max=nums[a];
                            i=a;
                        }
                    }
                    arr[point]=max;
                    point++;
                }
            }
            j++;
        }
        return arr;
    }
}