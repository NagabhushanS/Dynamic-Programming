// Longest Increasing Subsequence

import java.util.Scanner;

public class LongestIncreasingSubsequence {
	
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++){
			a[i] = in.nextInt();
		}
		
		System.out.println(getLongestIncreasingSubsequenceLength(a));
	}

	private static Integer getLongestIncreasingSubsequenceLength(int[] a) {
		final int n = a.length;
		int[] hash1 = new int[n];
		int[] hash2 = new int[n];
		for(int i=0; i<n; i++){
			hash1[i] = 1;
			hash2[i] = -1;
		}
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		for(int i=1; i<n; i++){
			for(int j=0; j<=i-1; j++){
				if (a[j]<a[i]){
					hash1[i] = Math.max(hash1[i], 1+hash1[j]);
					hash2[i] = j;
				}
			}
			max = Math.max(max, hash1[i]);
			if (hash1[i]==max){
				maxIndex = i;
			}
		}
		for(int i=0; i<n; i++){
			System.out.print(hash2[i]+" ");
		}
		System.out.println();
		
		int t = maxIndex;
		while(t!=-1){
			System.out.print(a[t]+" ");
			t = hash2[t];
		}
		System.out.println();
		return max;
	}
}