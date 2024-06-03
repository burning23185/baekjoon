import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < t ; i++){
            int answer = 0;
            String[] temp = br.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);

            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();

            String[] temp_a = br.readLine().split(" ");
            String[] temp_b = br.readLine().split(" ");

            for(int j = 0 ; j < n; j ++) a.add(Integer.parseInt(temp_a[j]));
            for(int k = 0 ; k < m; k ++) b.add(Integer.parseInt(temp_b[k]));

            Collections.sort(a);
            Collections.sort(b);

            int flag_a = 0;
            int flag_b = 0;

            while(flag_a < a.size() && flag_b < b.size()){
                //a 가 큰 경우 정답의 갯수를 올리고 다음 b를 가져옴
                if(a.get(flag_a) > b.get(flag_b)){
                    answer += (a.size() - flag_a);
                    flag_b++;
                    continue;
                }
                flag_a++;
            }
            sb.append(answer).append('\n');
        }
        System.out.println(sb.toString());
        br.close();
    }
}