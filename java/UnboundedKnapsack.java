public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] val = {10,40, 50, 70};
        int[] wt = {1,3,4,5};
        int w = 10;
        int res = solve(wt, val, wt.length, w);
        System.out.println(res);
    }
    //tabulation O(n*w)
    static int solve(int[] wt, int[] val, int n, int w){

        int[][] dp =new int[n+1][w+1];
        
        for(int i=0; i<=n; i++){
            for(int j=0; j<=w; j++){
                
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                else if(wt[i-1] <= j){
                    dp[i][j] = Math.max( val[i-1] + dp[i][j - wt[i-1]],
                                            dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
}
