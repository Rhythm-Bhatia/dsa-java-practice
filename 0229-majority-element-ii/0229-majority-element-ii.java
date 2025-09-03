class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        Set<Integer>set=new HashSet();
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>n/3){
                set.add(nums[i]);
            }
        }
        List<Integer>list=new ArrayList<>(set);
        return list;
    }
}