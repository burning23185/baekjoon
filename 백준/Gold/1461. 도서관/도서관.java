import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int move(List<Integer> first, List<Integer> second, int m){
        int ans = 0 ;
        if(!first.isEmpty()){
            first.sort(Comparator.reverseOrder());
            for(int i = 0 ; i < first.size() ; i += m) ans += 2 * first.get(i);
        }

        second.sort(Comparator.naturalOrder());
        for(int i = second.size()-1  ; i >= 0; i -= m) ans += 2 * second.get(i);

        ans -= second.get(second.size()-1);
        return ans;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs =  br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        String[] books = br.readLine().split(" ");
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        int max_left = 0;
        int max_right = 0;

        for(int i = 0 ; i < books.length ; i++) {
            int a = Integer.parseInt(books[i]);
            if(a < 0) {
                max_left = Math.max(max_left, -1 * a);
                left.add(-1 * a);
                continue;
            }
            max_right = Math.max(max_right, a);
            right.add(a);
        }

        boolean is_left_start = max_left > max_right;

        List<Integer> first;
        List<Integer> second;

        if(is_left_start) {
            first = right;
            second = left;
        }else{
            first = left;
            second = right;
        }

        System.out.println(move(first, second, m));
        br.close();
    }
}