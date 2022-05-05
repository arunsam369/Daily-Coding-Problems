problem :
There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

solution:
import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("enter n value : ");
        int n=sc.nextInt();
        System.out.print(helper(n));
    }
public static int helper(int n){
    if(n<2) return 1;
    int dp[]=new int[n];
    dp[0]=1;
    dp[1]=2;
    for(int i=2;i<n;i++){
        dp[i]=dp[i-1] + dp[i-2];
    }
    return dp[n-1];
}
}
