import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static int findInsertPosition(int num, ArrayList<Integer> res) {
        int left = 0, right = res.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if(res.get(mid) == num) return mid;

            if (res.get(mid) > num) {
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 0 ; i < n ;i++){
            int now_value = Integer.parseInt(st.nextToken());
            int insertPosition = findInsertPosition(now_value, res);

            if (insertPosition == res.size()) {
                res.add(now_value);
            } else if (res.get(insertPosition) > now_value) {
                res.set(insertPosition, now_value);
            }
        }

        System.out.println(res.size());
    }
}