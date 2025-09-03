class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        if(n<3) return new ArrayList<>();
        Set<List<Integer>>set=new HashSet();
        for(int i=0;i<n-2;i++){
            int sum=0;
            int left=i+1;
            int right=n-1;
            while(left<right){
                sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    set.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                }
                else if(sum<0){
                    left++;
                }
                else{
                    right--;
                }

            }

        }
        return new ArrayList<>(set);
    }
}