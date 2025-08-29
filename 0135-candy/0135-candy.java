class Solution {
    public int candy(int[] ratings) {
        if(ratings.length==0){
            return 0;
        }
        int arr1[]=new int[ratings.length];
        arr1[0]=1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1]){
                arr1[i]=arr1[i-1]+1;
            }
            else{
                arr1[i]=1;
            }
        }
        int arr2[]=new int [ratings.length];
        arr2[ratings.length-1]=1;
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                arr2[i]=arr2[i+1]+1;
            }
            else{
                arr2[i]=1;
            }
        }
        int ans=0;
        int finals[]=new int[ratings.length];
        for(int i=0;i<finals.length;i++){
            finals[i]=Math.max(arr1[i],arr2[i]);
            ans=ans+finals[i];
        }
        return ans;
    
    }
}