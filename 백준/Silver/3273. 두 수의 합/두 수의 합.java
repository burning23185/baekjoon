import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> nums = new ArrayList<>(100_000);

        String[] temp = br.readLine().split(" ");        

        for(int i = 0; i < n ; i++) nums.add(Integer.parseInt(temp[i]));

        int m = Integer.parseInt(br.readLine());

        Collections.sort(nums);
        int left = 0;
        int right = n-1;
        int answer = 0;

        while(left < right){
            if(nums.get(left) + nums.get(right) == m){
                answer++;
                left++;
                continue;
            }
            if(nums.get(left) + nums.get(right) < m){
                left++;
                continue;
            }
            right--;
        }
        
        System.out.println(answer);
        br.close();
    }
}