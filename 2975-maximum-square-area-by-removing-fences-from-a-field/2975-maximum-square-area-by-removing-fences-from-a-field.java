class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        

        int finalhFences[]= new int[hFences.length+2];
        int finalvFences[]= new int[vFences.length+2];

        finalhFences[0]=1;
        finalvFences[0]=1;
        for(int i=1;i<finalhFences.length-1;i++){
            finalhFences[i]=hFences[i-1];
        }
        finalhFences[finalhFences.length-1]=m;

        for(int i=1;i<finalvFences.length-1;i++){
            finalvFences[i]=vFences[i-1];
        }
        finalvFences[finalvFences.length-1]=n;
        Arrays.sort(finalhFences);
        Arrays.sort(finalvFences);

        Set<Integer>set=new HashSet<>();

        for(int i=1;i<finalhFences.length;i++){
            int j=i;
            while(j!=0){
                j--;
                int sub=finalhFences[i]-finalhFences[j];
                set.add(sub);

            }
        }
        long maxSide=-1;
        for(int i=1;i<finalvFences.length;i++){
            int j=i;
            while(j!=0){
                j--;
                int subb=finalvFences[i]-finalvFences[j];
                if(set.contains(subb)){
                    maxSide=Math.max(subb,maxSide);
                }

            }
        }
        if(maxSide==-1)return -1;
        long area=(maxSide*maxSide);
        
        area=(long)area%(1000000000+7);
        return (int)area;

    
    }
}