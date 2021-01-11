import java.util.Arrays;

public class LCS {
    static int[][] dp;
    public static void main(String[] args) {
        String x = "abcdef";
        String y = "afchdke"; //GTAB
        dp = new int[x.length()+1][y.length()+1];
        //init 2d array with -1
        for(int[] a: dp){
            Arrays.fill(a, -1);
        }

        int res = lcs3(x.toCharArray(), x.length(), y.toCharArray(), y.length());
        System.out.println(res);
        
    }
    //recursion solution
    static int lcs(char[] a, int n, char[] b, int m){
        if(n==0 || m==0) return 0;


        if(a[n-1] == b[m-1])
            return 1+ lcs(a, n-1,b,m-1);
        else   
            return Math.max( lcs(a,n,b,m-1), lcs(a,n-1,b,m) );
    }
    //memoize
    static int lcs2(char[] a, int n, char[] b, int m){
        if(n==0 || m==0) return 0;

        if(dp[n][m] != -1)
            return dp[n][m];

        if(a[n-1] == b[m-1])
            return dp[n][m] = 1+ lcs(a, n-1,b,m-1);
        else   {
            dp[n][m-1] = lcs(a,n,b,m-1);
            dp[n-1][m] = lcs(a,n-1,b,m);
            dp[n][m] = Math.max(dp[n][m-1] , dp[n-1][m]);
            return dp[n][m];
        }
            
    }
    //tabulation
    static int lcs3(char[] a, int n, char[] b, int m){
        int[][] dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }else if(a[i-1] == b[j-1]){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max( dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
