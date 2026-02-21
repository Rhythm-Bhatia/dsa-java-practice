class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans=0;
        for(int i=left;i<=right;i++){
            int count=0;
            int temp=i;
            while(temp!=0){
                temp=temp&(temp-1);
                count++;
            }
            if(isPrime(count)==true){
                ans++;
            }
        }
        return ans;
    }
    public boolean isPrime(int num){
        if(num<2)return false;
        for(int i=2;i<=Math.pow(num,0.5);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
