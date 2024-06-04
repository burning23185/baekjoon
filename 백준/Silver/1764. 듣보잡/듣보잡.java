import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);
		String temp = "";

		HashMap<String, Integer> n_numbers = new HashMap<>();
		ArrayList<String> m_numbers = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			n_numbers.put(br.readLine(), 1);
		}

		int result = 0;

		for (int j = 0; j < m; j++) {
			temp = br.readLine();
			if (n_numbers.containsKey(temp)) {
				m_numbers.add(temp);
				result++;
			}
		}

		sb.append(result).append("\n");

		Collections.sort(m_numbers);
		for (String str : m_numbers) {
			sb.append(str).append("\n");
		}

		System.out.println(sb);
		br.close();
	}
}