import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =  Integer.parseInt(br.readLine());

        String[] inputs = new String[n];

        for(int i= 0 ; i < n ; i++) inputs[i] = br.readLine();

        String now;
        int flag = 0;
        Set<String> madmax = new HashSet<>();

        for(int j = 0 ; j < n ; j++){
            now = br.readLine();

            //만약 현재 차량이 추월 차랑이면 추월되지 않는 차량까지 flag 이동
            while(madmax.contains(inputs[flag])) flag++;

            //만약 순번이 일치하는 차량인 경우 flag + 1 후 다음 출차 차량으로 이동
            if(inputs[flag].equals(now)){
                flag++;
                continue;
            }

            madmax.add(now);
        }

        System.out.println(madmax.size());
        br.close();
    }
}