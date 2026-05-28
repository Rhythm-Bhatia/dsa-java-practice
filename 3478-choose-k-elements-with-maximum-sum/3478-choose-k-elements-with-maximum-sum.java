class Solution {
    class Pair{
        int num1;
        int num2;
        int index;
        Pair(int num1,int num2,int index){
            this.num1=num1;
            this.num2=num2;
            this.index=index;
        }
    }
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        long[]ans=new long[nums1.length];
        List<Pair>list=new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            list.add(new Pair(nums1[i],nums2[i],i));
        }
        Collections.sort(list,(a,b)->{
            return Integer.compare(a.num1,b.num1);
        });
        PriorityQueue<Integer>pq=new PriorityQueue();
        long sum=0;
        for(int i=0;i<nums1.length;i++){
            Pair p=list.get(i);
            int indexx=p.index;
            if(i>0&&list.get(i-1).num1==p.num1){
                ans[indexx]=ans[list.get(i-1).index];
            }
            else{
                ans[indexx]=sum;
            }
            pq.add(p.num2);
            sum=sum+p.num2;
            if(pq.size()>k){
                sum-=pq.poll();
            }

            
            
        }
        return ans;
    }
}