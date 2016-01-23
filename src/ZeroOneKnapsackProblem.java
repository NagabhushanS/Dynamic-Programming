// Zero One Knapsack Problem

import java.util.Scanner;

public class ZeroOneKnapsackProblem {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int n = in.nextInt();
		int[] weights = new int[n];
		int[] values = new int[n];
		for (int i = 0; i < n; i++) {
			weights[i] = in.nextInt();
		}
		for (int i = 0; i < n; i++) {
			values[i] = in.nextInt();
		}
		int sum = in.nextInt();
		System.out.println(getMaxValue(weights, values, sum));

	}

	private static Integer getMaxValue(int[] weights, int[] values, int sum) {
		final int n = weights.length;
		int[][] hash = new int[n+1][sum+1];
		for(int i=1; i<=n; i++){
			for(int j=1; j<=sum; j++){
				if (weights[i-1]>j){
					hash[i][j] = hash[i-1][j];
				} else if (weights[i-1]==j){
					hash[i][j] = Math.max(hash[i-1][j], values[i-1]);
				} else{
					hash[i][j] = Math.max(hash[i-1][j], values[i-1]+hash[i-1][j-weights[i-1]]);
				}
			}
		}
		return hash[n][sum];
	}

}
