import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String temp_num = "";
		int temp_sum = 0;
		int result = 0;
		
		for (int i = n / 2; i < n; i++) {
			temp_num = Integer.toString(i);
			temp_sum = 0;
			
			// i 의 각 자리 수를 더함
			for (int j = 0; j < temp_num.length(); j++) {
				temp_sum += temp_num.charAt(j) - '0';
			}
			
			// i의 각 자리수와 i를 더한 값이 n과 같으면 break
			if ((i + temp_sum) == n) {
				result = i;
				break;
			}
		}

		// 결과 화면출력
		System.out.println(result);
		br.close();
	}
}