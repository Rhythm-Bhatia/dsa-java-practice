class Solution {
    public int minFlips(String s) {
        int length=s.length();
        int compare1=0;
        int compare0=0;
        int compare3=0;
        int compare4=0;
        int count1=0;
        for(int i=0;i<length;i++){
            char a=s.charAt(i);
            if(a=='0'){
                compare1++;
            }
            else{
                compare0++;
            }
            if(s.charAt(0)=='1'&&s.charAt(length-1)=='1'){
                if(i!=0&&i!=length-1){
                    if(a=='1'){
                        compare3++;
                    }
                }
            }
            if(count1==0&&a=='1'){
                count1++;
            }
            else{
                if(a=='1'){
                    compare4++;
                }
            }


        }
        int min=Math.min(compare1,Math.min(compare0,compare4));
        if(s.charAt(0)=='1'&&s.charAt(length-1)=='1'){
            min=Math.min(min,compare3);
        }
        return min;

    }
}