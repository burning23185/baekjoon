import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static class DataTable{
        private long[] dp;
        private long[] before;
        private int next_num;
        public DataTable(){
            this.dp = new long[1001];
            this.dp[1] = 10;
            this.before = new long[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            next_num = 2;

        }
        public void updateTable(int n){
            long temp = 0;
            long[] temp_sum = new long[11];

            for( int i = 0 ; i < 10 ; i++){
                temp += this.dp[n-1] - this.before[i];
                temp_sum[i+1] = temp;
            }
            this.dp[n] = temp;
            this.before = temp_sum;
        }
        public long getN(int n){
            while(this.next_num <= n) this.updateTable(this.next_num++);
            return this.dp[n];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        DataTable dt = new DataTable();

        for (int i=0 ; i < t ; i++) sb.append(String.format("%d%n", dt.getN(Integer.parseInt(br.readLine()))));

        System.out.println(sb);
        br.close();
    }
}