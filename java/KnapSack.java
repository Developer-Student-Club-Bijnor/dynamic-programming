import java.util.Arrays;

public class KnapSack {
    static int[][] dp;
    public static void main(String[] args) {
        int[] wt = {1,3,4,5};
        int[] val = {1,4,5,7};
        int n= 4;
        int w = 10;
        dp = new int[n+1][w+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=w; j++){
                dp[i][j] = -1;
            }
        }
        int res = recursive(wt, val, n, w);
        System.out.println("Max Profit "+res);
        
    }
    
    //recursive solution, TC = (2^n), SC = O(n)
    static int recursive(int wt[], int val[], int n, int w){

        if(n==0 || w==0)
            return 0;
        
        if( dp[n][w] != -1){
            return dp[n][w];
        }
        if( wt[n-1] <= w){
            dp[n][w] = Math.max( val[n-1] + recursive(wt, val, n-1, w - wt[n-1]), 
                                recursive(wt, val, n-1, w)
                            );
            return dp[n][w];
        }else{
            dp[n][w] = recursive(wt, val, n-1, w);
            return dp[n][w];
        }
        
    }
    //memoization TC=O(n*w)
    static int memoize(int wt[], int val[], int n, int w){

        if(n==0 || w==0)
            return 0;

        if( wt[n-1] <= w){
            return Math.max( val[n-1] + memoize(wt, val, n-1, w - wt[n-1]), 
                                memoize(wt, val, n-1, w)
                            );
        }else{
            return memoize(wt, val, n-1, w);
        }
        
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
                    dp[i][j] = Math.max( val[i-1] + dp[i-1][j - wt[i-1]],
                                            dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }

}