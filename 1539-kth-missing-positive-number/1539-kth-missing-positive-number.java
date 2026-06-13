class Solution {
    public int findKthPositive(int[] arr, int k) {
        int high=arr[arr.length-1];
        int low=arr[0];
        int diff=high-low-1;
        int subtract=0;
        int len=arr.length;
        if(arr.length!=1){
            subtract=arr.length-0-2;
        }
        int sum=diff-subtract;
        

        if(arr.length==1){
            
            if(k>=low){
                return k+1;
            }
            else{
                return k;
            }

        }
        if(k>sum){
            return (k-sum-low+1)+high;
        }
        if(k<low){
            return k;
        }
        int temp=low;
        int count=low-1;
        boolean flag=false;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=temp){
                
                while(arr[i]!=temp){
                    if(count+1==k){
                        flag=true;
                        break;
                    }
                    temp=temp+1;
                    count++;
                }
                if(flag==true)break;
                temp=temp+1;
                
            }
            else{
                // count++;
                temp=temp+1;
            }
        }
        return temp;
    }
}