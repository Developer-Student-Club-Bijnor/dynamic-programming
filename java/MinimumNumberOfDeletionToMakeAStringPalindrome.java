public class MinimumNumberOfDeletionToMakeAStringPalindrome {
    public static void main(String[] args) {
        String x = "aibja";
        int n = x.length();
        //reverse the string x into y
        String y = new StringBuilder(x).reverse().toString();
        int m = y.length();
        int res = lcs3(x.toCharArray(), n, y.toCharArray(), m);
        System.out.println("Minimum Deletion : "+(n-res));
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
