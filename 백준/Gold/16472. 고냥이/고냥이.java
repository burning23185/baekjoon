import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n =  Integer.parseInt(br.readLine());

        String inputs = br.readLine();

        Queue<Character> q = new LinkedList<>();
        Set<Character> in_storage = new HashSet<>();
        int[] storage = new int['z' - 'a' + 1];

        int ans = 0;
        char now;
        char removed;

        for(int j = 0 ; j < inputs.length(); j++){
            now = inputs.charAt(j);
            q.offer(now);
            in_storage.add(now);
            storage[now - 'a']++;

            while(in_storage.size() > n){
                removed = q.poll();
                if(--storage[removed - 'a'] == 0) in_storage.remove(removed);
            }
            
            ans = Math.max(ans, q.size());
        }

        System.out.println(ans);
        br.close();
    }
}