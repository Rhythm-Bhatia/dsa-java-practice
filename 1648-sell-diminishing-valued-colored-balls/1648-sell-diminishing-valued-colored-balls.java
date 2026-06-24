class Solution {
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int n = inventory.length;
        long ans = 0;
        final long MOD = (long)(1e9 + 7);

        for(int i=n-1 ; i>=0 && orders > 0; i--){

            int d = inventory[i] - (i > 0 ? inventory[i-1] : 0);
            long x = 1l*d*(n-i);

            if(x <= orders){
                orders -= x;

                long v = sum(inventory[i]) - sum(inventory[i]-d);

                v = (v*(n-i))%MOD;

                ans = (ans + v)%MOD;
            }
            else{
                int r = orders/(n-i);
                long ext = orders%(n-i);


                long v = sum(inventory[i]) - sum(inventory[i]-r);
                v = (v*(n-i))%MOD;

                ans = (ans + v)%MOD;

                long e = (ext*(inventory[i]-r))%MOD;

                ans = (ans + e)%MOD;

                orders = 0;
            }
        }

        return (int)ans;
    }

    public long sum(int x){
        return ((1l*x)*(x+1))/2;
    }
}