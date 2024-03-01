import java.io.*;
import java.util.*;

public class Main {

	public int select(Integer[] nums, int n, int target) {
		int result = 0;
		
		for (int j = 0; j < n - 2; j++) {
			for (int k = j + 1; k < n - 1; k++) {
				for (int p = k + 1; p < n; p++) {
					int res = nums[j] + nums[k] + nums[p];
					if (res <= target) {
						result = result < res ? res : result;
					}
				}
			}
			
		}
		return result;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int target = Integer.parseInt(inputs[1]);
		inputs = br.readLine().split(" ");
		Integer[] nums = new Integer[n];
		for (int i = 0; i < n; i++)
			nums[i] = Integer.parseInt(inputs[i]);
		Main tm = new Main();
		System.out.println(tm.select(nums, n, target));
	}
}