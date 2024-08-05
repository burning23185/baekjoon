import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    private final PriorityQueue<Integer> cards;

    public Main(){
        cards = new PriorityQueue<>();
    }

    public void addUnit(int unit){
        cards.add(unit);
    }

    private int run(){
        if(cards.size() == 1) return 0;
        int temp;
        int ans = 0;
        while(cards.size() > 1){
            temp = cards.poll() + cards.poll();
            ans += temp;
            cards.add(temp);
        }
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
