import java.io.*;

public class Main {
    static class Position{
        private int x;
        private int y;

        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());


        Position[] dir = {
                new Position(1,0),new Position(0,1),new Position(-1,0),new Position(0,-1)
        };

        int[][] map = new int[n][n];
        Position now = new Position(0,0);
        Position next;
        int flag = 0;
        int val = n*n;
        while(val > 0){
            map[now.getX()][now.getY()] = val--;

            next = new Position(now.getX() + dir[flag].getX(), now.getY() + dir[flag].getY());
            if(next.getX() >= n || next.getY() >= n || next.getX() < 0 || map[next.getX()][next.getY()] != 0){
                flag = (flag < 3) ? flag + 1 : 0;
            }
            now = new Position(now.getX() + dir[flag].getX(), now.getY() + dir[flag].getY());
        }

        Position target_position = new Position(-1,-1);

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(map[i][j] == target) target_position = new Position(i+1, j+1);
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(target_position.getX()).append(" ").append(target_position.getY());
        System.out.println(sb);
        br.close();
    }
}