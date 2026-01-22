class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int count=0;
        for (int n : nums) {
            list.add(n);
        }
        // List<Integer>list=Arrays.asList(nums);
        // Map<Integer,Integer>map=new LinkedHashMap<>();
        // Set<Integer>set=new LinkedHashSet<>();
        
        
        while(list.size()!=1){
            int min=Integer.MAX_VALUE;
            int c=0;
            int d=0;
            boolean bool=true;
            for(int i=0;i<list.size()-1;i++){
                if(list.get(i)<=list.get(i+1))continue;
                else {
                    bool=false;
                    break;
                }
            }
            if(bool==true)break;

            for(int i=list.size()-1;i>0;i--){
                int a=list.get(i);
                int b=list.get(i-1);
                int sum=a+b;
            

                if(sum<=min){
                
                    min=sum;
                    c=i;
                    d=i-1;
                    

                }
        
                
            }
            list.remove(c);
            list.remove(d);
            list.add(d,min);
            count++;
    
        }
        return count;
        
    }


}