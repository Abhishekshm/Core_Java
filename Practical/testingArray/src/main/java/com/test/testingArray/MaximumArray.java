package com.test.testingArray;

public class MaximumArray {

	int arr[];

	public int maxMin(int arr[]) {

		int max = arr[0];

		for (int i = 0; i < 5; i++) {

			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	public int min(int arr[]) {
		int min = arr[0];
		for (int i = 0; i < 5; i++) {

			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}

}
