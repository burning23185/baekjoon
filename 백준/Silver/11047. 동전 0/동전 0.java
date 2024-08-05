import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private final List<Integer> coins;

    public Main(){
        coins = new ArrayList<>();
    }

    public void addUnit(int unit){
        coins.add(unit);
    }

    private int run(int target){
        int res = 0;
        for(int i = coins.size()-1 ; i >= 0 ; i--){
            if(coins.get(i) > target) continue;

            res += target/coins.get(i);
            target = target % coins.get(i);
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main m = new Main();

        String[] conf = br.readLine().split(" ");

        for(int i = 0 ; i < Integer.parseInt(conf[0]) ; i++){
            m.addUnit(Integer.parseInt(br.readLine()));
        }
        System.out.println(m.run(Integer.parseInt(conf[1])));
    }
}
