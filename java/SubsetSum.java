public class SubsetSum {
    static boolean[][] dp;
    public static void main(String[] args) {
        int arr[] = {2,3, 5, 9};
        int n = arr.length;
        int sum = 15;
        dp = new boolean[n+1][sum+1];
        boolean res  = tab(arr, n, sum);
        System.out.println("Result : "+res);
    }
    //recursive solution, TC = O(2^n) {exponential}
    static boolean solve(int[] arr, int n, int sum) {
        if(sum == 0){
            return true;
        }
        if(n == 0){
            return false;
        }
        if(arr[n-1] <= sum){
            return solve(arr, n-1, sum-arr[n-1]) || solve(arr, n-1, sum);                  
        }else{
            return solve(arr, n-1, sum);
        }
    }

    //memoization tc = O(n*sum) recursion stack
    static boolean memo(int[] arr, int n, int sum) {
        //System.out.println(n+","+sum);
        if(sum == 0){
            return true;
        }
        if(n == 0){
            return false;
        }
        if(dp[n][sum] == true)
            return dp[n][sum];
        
        if(arr[n-1] <= sum){
            return dp[n][sum] = memo(arr, n-1, sum-arr[n-1]) || memo(arr, n-1, sum);                  
        }else{
            return dp[n][sum] = memo(arr, n-1, sum);
        }
        
    }
    //tabulation O(n*sum)
    static boolean tab(int[] arr, int n, int sum){
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j<sum+1;j++){
                if(j==0){
                    dp[i][j] = true;
                }else if(i==0){
                    dp[i][j] = false;
                }else if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
