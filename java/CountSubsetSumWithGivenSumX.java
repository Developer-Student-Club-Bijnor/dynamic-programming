import java.util.Arrays;

public class CountSubsetSumWithGivenSumX {
    public static void main(String[] args) {
        int[] ar = {1,1,1,1};
        int sum = 1;
        int res = tab(ar, ar.length, sum);
        System.out.println(res);
    }
    //tabulation O(n*sum)
    static int tab(int[] arr, int n, int sum){
        int[][] dp = new int[n+1][sum+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1;j++){
                if(j==0){
                    dp[i][j] = 1;
                }else if(i==0){
                    dp[i][j] = 0;
                }else if(arr[i-1] <= j){
                    // 4 1        3    0                3     1
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        for(int[] a : dp){
            System.out.println(Arrays.toString(a));
        }
        return dp[n][sum];
    }

     //recursive solution, TC = O(2^n) {exponential}
     static int solve(int[] arr, int n, int sum) {
        if(sum == 0){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        if(arr[n-1] <= sum){
            return solve(arr, n-1, sum-arr[n-1]) + solve(arr, n-1, sum);                  
        }else{
            return solve(arr, n-1, sum);
        }
    }
}
