public class FibSolution{
    static int t[];
    public static void main(String[] args) {
        int n = 10;
        t = new int[n+1];
        for(int i=0; i<n+1;  i++){
            t[i] =  -1;
        }
        t[0] = 0;
        t[1] = 1;
        int res = fib3(6);

        System.out.println("Nth term: "+res);
    }

    //recursive solution TC = O(2^n), SC = O(n)
    static int fib(int n){
        if(n<2)
            return n;
        return fib(n-1) + fib(n-2);
    }
    
    //memoization TC=O(n), SC= O(n)
    static int fib2(int n){
        if(n<2)
            return n;

        if( t[n] != -1)
            return t[n];
        t[n] = fib2(n-1) + fib2(n-2);
        return t[n];
    }
    //tabulation TC=O(n), SC = O(n)
    static int fib3(int n){ 
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for(int i=2; i<=n; i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n]; 
    }


}