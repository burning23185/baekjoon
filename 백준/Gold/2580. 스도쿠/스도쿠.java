import java.io.*;
import java.util.ArrayList;

public class Main {

	// 놓을 수 있는 경우의 수 탐색
	static class Dfs {
		private int n;
		private int[][] board;
		private boolean is_end;

		public Dfs(int n, int num_of_zero, int[][] board) {
			this.n = n;
			this.board = board;
			this.is_end = false;
			doDfs(0, 0);
		}

		void doDfs(int x, int y) {
			if (x == this.n) {
				doDfs(0, y + 1);
				return;
			}

			// 사각형의 모든 숫자가 채워진 경우
			if (y == this.n) {
				this.is_end = true;
				return;
			}

			if (this.board[y][x] == 0) {
				for (int i = 1; i <= this.n; i++) {
					if (is_possible(x, y, i)) {
						this.board[y][x] = i;
						doDfs(x + 1, y);
					}
					if (this.is_end) {
						return;
					}
				}
				this.board[y][x] = 0;
				return;
			}
			doDfs(x + 1, y);
		}

		boolean is_possible(int x, int y, int num) {
			// ㅡ 방향 중복 검사
			for (int i = 0; i < 9; i++) {
				if (this.board[y][i] == num) {
					return false;
				}
			}

			// | 방향 중복 검사
			for (int j = 0; j < 9; j++) {
				if (this.board[j][x] == num) {
					return false;
				}
			}

			int x_idx = x / 3;
			int y_idx = y / 3;
			// 3X3 사각형 중복 검사
			for (int k = y_idx * 3; k < (y_idx + 1) * 3; k++) {
				for (int p = x_idx * 3; p < (x_idx + 1) * 3; p++) {
					// 중복된 숫자가 있다면 false;
					if (this.board[k][p] == num) {
						return false;
					}
				}
			}
			return true;
		}

		public String getResult() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < this.n; i++) {
				for (int j = 0; j < this.n; j++) {
					sb.append(this.board[i][j]).append(" ");
				}
				sb.append("\n");
			}
			return sb.toString();
		}
	}

	public static void main(String[] srgs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str_nums;
		int[][] board = new int[9][9];
		int temp_num = 0;
		int num_of_zero = 0;
		int n = 9;
		for (int i = 0; i < n; i++) {
			str_nums = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				temp_num = Integer.parseInt(str_nums[j]);
				board[i][j] = temp_num;
			}
		}

		Dfs dfs = new Dfs(n, num_of_zero, board);
		System.out.println(dfs.getResult());
	}
}