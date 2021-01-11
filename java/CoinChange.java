import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] arr = {1,2,3}; 
        int N = 4;
        int res = tab(arr, arr.length, N);
        System.out.println(res);
    }
    //count subsets with given sum X 
    static int tab(int[] arr, int n, int sum){
        int[][] dp = new int[n+1][sum+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1;j++){
                if(j==0){
                    dp[i][j] = 1;
                }else if(i==0){
                    dp[i][j] = 0;
                }else if(arr[i-1] <= j){
                    dp[i][j] = dp[i][j-arr[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        for(int[] a: dp){
            System.out.println(Arrays.toString(a));
        }

        return dp[n][sum];
    }
}
