class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int max=0;
        for(int i=0;i<bottomLeft.length;i++){
            for(int j=i+1;j<bottomLeft.length;j++){
                int bleftx=Math.max(bottomLeft[i][0],bottomLeft[j][0]);
                int blefty=Math.max(bottomLeft[i][1],bottomLeft[j][1]);

                int trightx=Math.min(topRight[i][0],topRight[j][0]);
                int trighty=Math.min(topRight[i][1],topRight[j][1]);

                int width=trightx-bleftx;
                int height=trighty-blefty;
                int side=Math.min(width,height);
                max=Math.max(side,max);
                
            }
        }
        long area=1L*max*max;
        return area;
    }
}