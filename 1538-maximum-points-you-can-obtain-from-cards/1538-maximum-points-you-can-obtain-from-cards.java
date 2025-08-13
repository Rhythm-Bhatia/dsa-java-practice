class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int maxCard=0;
        int sum=0;
        for(int i=0;i<k;i++){
            sum=sum+cardPoints[i];
            maxCard=Math.max(maxCard,sum);
        }

        int left=k-1;
        int right=n-1;
        for(int i=0;i<k;i++){
            sum=sum-cardPoints[left];
            sum+=cardPoints[right];
            maxCard=Math.max(maxCard,sum);
            right--;
            left--;
        }
        return maxCard;


    }
}