// Box Stacking Problem

import java.util.Scanner;

public class BoxStackingProblem {

	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = in.nextInt();
		int[][] a = new int[n][3];
		for(int i=0; i<n; i++){
			a[i][0] = in.nextInt();
			a[i][1] = in.nextInt();
			a[i][2] = in.nextInt();
		}
		
		System.out.println(getMaximumHeight(a));
	}

	private static Integer getMaximumHeight(int[][] a) {
		final int n = a.length;
		int[][] p = new int[3*n][3];
		for(int j=0; j<n; j+=1){
			int i = 3*j;
			p[i][0] = a[j][0];
			p[i][1] = a[j][1];
			p[i][2] = a[j][2];
			p[i+1][0] = a[j][1];
			p[i+1][1] = a[j][2];
			p[i+1][2] = a[j][0];
			p[i+2][0] = a[j][0];
			p[i+2][1] = a[j][2];
			p[i+2][2] = a[j][1];
		}

		sort(p);
		int[] max = new int[3*n];
		for(int i=0; i<3*n; i++){
			max[i] = p[i][2];
		}
		int maxHeight = 0;
		for(int i=0; i<3*n; i++){
			for(int j=0; j<=i-1; j++){
				if (p[j][0]>p[i][0] && p[j][1]>p[i][1]){
					max[i] = Math.max(max[i], p[i][2]+max[j]);
				}
			}
			maxHeight = Math.max(maxHeight, max[i]);
		}
//		for(int i=0; i<3*n; i++){
//			System.out.print(max[i]+" ");
//		}
//		System.out.println();
		return maxHeight;
	}
	
	private static void sort(int[][] b) {
		final int n =b.length;
		for(int i=1; i<n; i++){
			int j = i;
			int key = b[i][0]*b[i][1];
			int[] keyArray = b[i];
			while(j>0 && b[j-1][0]*b[j-1][1]<key){
				b[j] = b[j-1];
				j--;
			}
			b[j] = keyArray;
		}
		
	}

}
