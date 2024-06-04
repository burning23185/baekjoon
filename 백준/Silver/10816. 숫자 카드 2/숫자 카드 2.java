import java.io.*;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// n 입력
		int n = Integer.parseInt(br.readLine());
		String[] inputs = br.readLine().split(" ");

		HashMap<String, Integer> numbers = new HashMap<>();

		// n 카드에 해당하는 숫자들 입력
		for (int i = 0; i < n; i++) {
			if (numbers.containsKey(inputs[i])) {
				numbers.put(inputs[i], numbers.get(inputs[i]) + 1);
			} else {
				numbers.put(inputs[i], 1);
			}
		}

		// m 입력
		int m = Integer.parseInt(br.readLine());
		inputs = br.readLine().split(" ");

		for (int j = 0; j < m; j++) {

			if (numbers.containsKey(inputs[j])) {
				sb.append(numbers.get(inputs[j])).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb);
		br.close();
	}
}