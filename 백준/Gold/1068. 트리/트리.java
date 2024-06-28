import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static Map<Integer, List<Integer>> child;

    static int dfs(int now){
        int res = 0;
        if(child.get(now) == null) return 1;

        for(int n : child.get(now)) res += dfs(n);

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        child = new HashMap<>();
        int root = 0;
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; i++) nums[i] = Integer.parseInt(inputs[i]);
        int removed = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++){

            if(nums[i] == -1){
                root = i;
                continue;
            }

            if(nums[i] == removed || i == removed) continue;

            if(child.containsKey(nums[i])){
                child.get(nums[i]).add(i);
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                child.put(nums[i], temp);
            }
        }

        System.out.println( root == removed ? 0 :dfs(root));
        br.close();
    }
}