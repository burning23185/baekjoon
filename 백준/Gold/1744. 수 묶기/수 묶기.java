import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    private final PriorityQueue<Integer> pq_plus;
    private final PriorityQueue<Integer> pq_minus;

    public Main(){
        pq_plus = new PriorityQueue<>(Comparator.reverseOrder());
        pq_minus = new PriorityQueue<>();
    }

    public void addUnit(int unit){
        if(unit > 0) pq_plus.add(unit);
        else pq_minus.add(unit);
    }
    public int run(){
        int ans = 0;

        while(pq_minus.size() > 1){
            ans += pq_minus.poll() * pq_minus.poll();
        }
        ans += pq_minus.isEmpty() ? 0 : pq_minus.poll();

        int a,b;
        while(pq_plus.size() > 1){
            a = pq_plus.poll();
            b = pq_plus.poll();
            if(a == 1 || b == 1) {
                ans += a + b;
                continue;
            }
            ans += a*b;
        }
        ans += pq_plus.isEmpty() ? 0 : pq_plus.poll();
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main m = new Main();
        int t = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < t ; i++){
            m.addUnit(Integer.parseInt(br.readLine()));
        }
        System.out.println(m.run());
    }
}