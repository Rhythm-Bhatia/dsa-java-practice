class Solution {
    public boolean containsZero(int num){
        while(num>0){
            if(num%10==0)return true;
            
            num=num/10;
            
        }
        return false;
    }
    public int[] getNoZeroIntegers(int n) {
        // int arr[]=new int[2];
        for(int i=1;i<n;i++){
            int b=n-i;
            if(!containsZero(i)&&!containsZero(b)){
                return new int[]{i,n-i};
            }
        }
        return new int[0];
    }
}