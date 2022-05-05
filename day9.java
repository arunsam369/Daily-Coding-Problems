Problem: 	A builder is looking to build a row of N houses that can be of K different colors. He has a goal of minimizing cost 
		while ensuring that no two neighboring houses are of the same color.
		Given an N by K matrix where the nth row and kth column represents the cost to build 
		the nth house with kth color, return the minimum cost which achieves this goal.
		
Solution:	public class MinCost {

		    int finMinCost(int[][] arr, int N, int K) {
			int dp[][] = new int[N][K];
			for(int j = 0; j < K; j++)
			    dp[0][j] = arr[0][j];

			for(int i = 1; i < N; i++) {
			    int min1 = Integer.MAX_VALUE;
			    int min2 = Integer.MAX_VALUE;
			    for(int j = 0; j < K; j++) {
				if (dp[i - 1][j] < min1) {
				    min2 = min1;
				    min1 = dp[i - 1][j];
				} else if (dp[i - 1][j] < min2)
				    min2 = dp[i - 1][j];
			    }
			    
			    for(int j = 0; j < K; j++) {
				if(dp[i-1][j] != min1)
				    dp[i][j] = arr[i][j] + min1;
				else
				    dp[i][j] = arr[i][j] + min2;
			    }
			}

			int min = Integer.MAX_VALUE;
			for(int j = 0; j < K; j++)
			    min = Math.min(min, dp[N-1][j]);
			return min;
		    }
		}
		
		import java.util.*;
		public class MinCostDemo {

		    public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);

			MinCost mc = new MinCost();

			System.out.println("Enter no.of houses");
			int n = sc.nextInt();
			System.out.println("Enter no.of colors to use");
			int k = sc.nextInt();

			System.out.println("Enter the cost of "+k+" colors for each house");
			int arr[][] = new int[n][k];
			for(int i = 0; i < n; i++) {
			    for(int j = 0; j < k; j++)
				arr[i][j] = sc.nextInt();
			}
			System.out.println("Min cost : "+mc.finMinCost(arr, n, k));
		    }
		}



