import java.util.Arrays;

public class LongetCommonSubstring {
    public static void main(String[] args) {
        String x= "abcdxyz";
        String y = "mnoxyzabcd";//1+dp[3][9]

        int res = lcs3(x.toCharArray(), x.length(), y.toCharArray(), y.length());
        System.out.println(res);
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
                    dp[i][j] = 0;
                }
            }
        }
        int max = 0;
        for(int i=0;i<=n; i++){
            for(int j=0; j<=m; j++){
                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
        for(int[] p: dp){
            System.out.println(Arrays.toString(p));
        }
        return max;
    }
}
