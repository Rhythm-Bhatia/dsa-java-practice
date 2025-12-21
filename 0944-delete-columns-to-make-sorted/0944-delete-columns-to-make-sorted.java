class Solution {
    public int minDeletionSize(String[] strs) {
        int count=0;
        for(int i=0;i<strs[0].length();i++){
            int prev=0;
            for(int j=0;j<strs.length;j++){
                int next=(int)strs[j].charAt(i);
                if(next<prev){
                    count++;
                    break;
                }
                prev=next;
                

            }
        }
        return count;
    }
}