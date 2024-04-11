import java.io.*;

public class Main {

	// 놓을 수 있는 경우의 수 탐색
	static class Dfs {
		private int n;
		private int result;
		private int[] selected_x;

		public Dfs(int n) {
			this.n = n;
			this.selected_x = new int[n];
			this.result = 0;
		}

		public void doDfs(int depth) {

			// 놓인 말의 갯수가 n 개일 때 카운트 증가 후 종료
			if (depth == this.n) {
				result++;
				return;
			}

			// x 좌표 첨부터 끝까지 진행
			for (int i = 0; i < this.n; i++) {
			
				// 현재 위치가 말을 놓을 수 있으면 위치 정보 저장 및 다음 말 위치 탐색
				if (isAvalivable(i, depth)) {
					this.selected_x[depth] = i;
					doDfs(depth + 1);
				}
			}
			return;
		}

		boolean isAvalivable(int x, int depth) {
			int exsist_x;
			// 퀸이 첫번째로 놓이는 경우
			if (depth == 0) {
				return true;
			}

			for (int j = 0; j < depth; j++) {
				exsist_x = this.selected_x[j];
				// | 모양에 queen 이 있는지 검사 ( ㅡ 방향은 y가 항상 아래로 1씩 증가함으로 고려 x)
				if (x == exsist_x) {
					return false;

				// X 모양에 queen 이 있는지 검사
				} else if (Math.abs(x - exsist_x) == Math.abs(depth - j)) {
					return false;
				}
			}
			return true;
		}

		public int getResult() {
			return result;
		}

	}

	public static void main(String[] srgs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Dfs dfs = new Dfs(n);
		dfs.doDfs(0);
		System.out.println(dfs.getResult());
	}
}