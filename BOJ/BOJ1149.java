package com.ssafy.algo.hw0914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[][] colorMap = new int[N][3];
		int[][] resultMap = new int[N][3];
		int[] lastIdx = new int[3];
		
		for (int tc = 0; tc < N; tc++) {
			st = new StringTokenizer(br.readLine(), " ");

			for(int rgb = 0 ; rgb < 3; rgb++) {
				colorMap[tc][rgb] = Integer.parseInt(st.nextToken());
			}

			//System.out.println(Arrays.toString(colorMap[tc]));
		}
		resultMap[0][0] = colorMap[0][0];
		resultMap[0][1] = colorMap[0][1];
		resultMap[0][2] = colorMap[0][2];
		lastIdx[0] = 0;
		lastIdx[1] = 1;
		lastIdx[2] = 2;
		
		for(int i = 1 ; i < N ; i++) {
			for(int j = 0 ; j < 3; j++) {
				int sum = Integer.MAX_VALUE;

				for(int k = 0 ; k < 3 ; k++) {
					if(lastIdx[j] == k) continue;
					if(sum > resultMap[i-1][k] + colorMap[i][j]) {
						sum = resultMap[i-1][k] + colorMap[i][j];
						resultMap[i][j] = resultMap[i-1][k] + colorMap[i][j];
					}
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0 ; i < 3 ; i++) {
			if(min > resultMap[N-1][i])
				min = resultMap[N-1][i];
		}
		System.out.println(min);
	}
}
