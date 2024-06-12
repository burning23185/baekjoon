import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Position{
        private int x;
        private int length;
        public Position(int x){
            this.x = x;
            this.length = 0;
        }

        public Position(int x, int length){
            this.x = x;
            this.length = length;
        }

        public int getX(){
            return this.x;
        }
        public int getLength(){ return this.length;}
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs =  br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        boolean[]visited = new boolean[200_000];
        visited[n] = true;

        Queue<Position> q = new LinkedList<>();
        q.add(new Position(n));

        Position now;
        int next_x;
        int ans = 0;

        while (q. size() > 0){
            now = q.poll();

            if(now.getX() == m) {
                ans = now.getLength();
                break;
            }

            for(int i = 0 ; i < 3 ; i++){
                if(i == 0){
                    next_x = now.getX() - 1;
                }else{
                    next_x = (i == 1) ? now.getX() + 1 : 2 * now.getX();
                }

                if(next_x < 0 || next_x >= visited.length) continue;
                if(visited[next_x]) continue;

                visited[next_x] = true;
                q.offer(new Position(next_x, now.getLength()+1));
            }
        }

        System.out.println(ans);
        br.close();
    }
}