import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 

        Map<String, Integer> ext_nums = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            String[] inputs = br.readLine().split("[.]");
            int temp = ext_nums.containsKey(inputs[1]) ? ext_nums.get(inputs[1]) : 0;
            ext_nums.put(inputs[1], temp + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        List<String> keys = new ArrayList<>(ext_nums.keySet());
        keys.sort(Comparator.naturalOrder());
        
        for(String key : keys){
            sb.append(key).append(' ').append(ext_nums.get(key)).append('\n');
        }
        System.out.println(sb.toString());
    }
}