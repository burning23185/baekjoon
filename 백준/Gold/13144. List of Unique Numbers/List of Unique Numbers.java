import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =  Integer.parseInt(br.readLine());

        String[] inputs = br.readLine().split(" ");
        int[] nums = new int[n];

        for(int i= 0 ; i < n ; i++) nums[i] = Integer.parseInt(inputs[i]);

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        long ans = 0;

        for(int j = 0 ; j < n ; j++){
            while(visited.contains(nums[j])){
                ans += q.size();
                visited.remove(q.poll());
            }
            q.offer(nums[j]);
            visited.add(nums[j]);
        }
        ans += (long) (visited.size() + 1) * visited.size()/2;

        System.out.println(ans);
        br.close();
    }
}