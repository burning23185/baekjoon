import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();
        String input = br.readLine();
        Deque<Character> deq = new LinkedList<>();
        for(int i = 0 ; i < input.length() ; i++) deq.offer(input.charAt(i));
        boolean is_reverse = false;
        char next;
        while(deq.size() != target.length()) {
            next = is_reverse ? deq.pollFirst() : deq.pollLast();
            if(next == 'B') is_reverse = !is_reverse;
        }

        StringBuilder sb = new StringBuilder();
        if(is_reverse){
            while(deq.size() > 0) sb.append(deq.pollLast());

        }else{
            while(deq.size() > 0) sb.append(deq.pollFirst());
        }

        System.out.print(sb.toString().equals(target) ? 1 : 0);
        br.close();
    }
}
