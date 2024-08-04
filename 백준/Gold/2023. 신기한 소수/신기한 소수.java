import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    StringBuilder sb;
    int n;
    public Main(int n){
        this.n = n;
    }

    public boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private void dfs(int before, int depth){
        if(depth == n) {
            sb.append(before).append("\n");
            return;
        }
        int now;
        for(int i = 1 ; i <= 9 ; i++){
            now = before*10 + i;
            if(!isPrime(now)) continue;
            dfs(now, depth+1);
        }
    }

    private String run(){
        sb = new StringBuilder();
        dfs(0,0);
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main m = new Main(Integer.parseInt(br.readLine()));
        System.out.println(m.run());
    }
}