public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String x = "aibjckbla";
        int n = x.length();
        //reverse string
        String y = new StringBuilder(x).reverse().toString();
        //call lcs on x and y
        int res = lcs3(x.toCharArray(), n, y.toCharArray(), n);
        System.out.println(n - res);
    }

    //LCS - tabulation
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
