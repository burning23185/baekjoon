import java.io.*;

public class Main {
	static class Dfs {
		private int n;
		private int m;
		private int[] visited;
		private StringBuilder result;

		public Dfs(int n, int m) {
			this.n = n;
			this.m = m;
			this.visited = new int[n + 1];
			this.result = new StringBuilder();
		}

		void doDfs(int depth, int now) {
			if (depth == m) {
				for (int i = 0; i < m; i++) {
					result.append(visited[i]).append(" ");
				}
				result.append("\n");
				return;
			}

			for (int j = now; j <= n; j++) {
				visited[depth] = j;
				doDfs(depth + 1, j+1);
			}
		}

		String getResult() {
			return result.toString();
		}
	}

	public static void main(String[] srgs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);

		Dfs dfs = new Dfs(n, m);
		dfs.doDfs(0, 1);

		System.out.println(dfs.getResult());
	}
}