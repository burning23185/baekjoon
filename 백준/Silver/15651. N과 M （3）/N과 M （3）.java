import java.io.*;

public class Main {

	static class Dfs {
		private StringBuilder result;
		private int n;
		private int m;
		private int[] selected;

		public Dfs(int n, int m) {
			this.n = n;
			this.m = m;
			this.result = new StringBuilder();
			selected = new int[m];
		}

		void doDfs(int depth) {
			if (depth == m) {
				for (int j = 0; j < m; j++) {
					result.append(selected[j]).append(" ");
				}
				result.append("\n");
				return;
			}

			for (int i = 1; i <= n; i++) {
				selected[depth] = i;
				this.doDfs(depth + 1);
			}
		}

		String getResult() {
			return result.toString();
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] inputs = br.readLine().split(" ");

		Dfs dfs = new Dfs(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));

		dfs.doDfs(0);

		System.out.println(dfs.getResult());
		br.close();
	}
}