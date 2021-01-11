public class EqualSumPatition {
    public static void main(String[] args) {
        int[] ar = {1, 5, 11, 5};
        int sum = 0;
        for(int i=0; i<ar.length; i++){
            sum+= ar[i];
        }
        if(sum % 2 == 1){
            System.out.println("false");
        }else{
            int x = sum /2;
            boolean res = tab(ar, ar.length, x);
            System.out.println(res);
        }
    }

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
