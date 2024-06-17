import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static class Position{
        private int x;
        private int y;

        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }

        public void updatePosition(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getX(){
            return this.x;
        }
        public int getY(){
            return this.y;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return this.x == position.getX() && this.y == position.getY();
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public static class MoveCommand {
        private int time;
        private boolean clockwise;

        public MoveCommand(int time, boolean clockwise) {
            this.time = time;
            this.clockwise = clockwise;
        }
        public int getTime(){
            return this.time;
        }
        public boolean isClockwise(){
            return this.clockwise;
        }
    }
    public static char rotate(char before, boolean clockwise){
        switch (before){
            case 'L':
                return clockwise ? 'U' : 'D';
            case 'R':
                return clockwise ? 'D' : 'U';
            case 'U':
                return clockwise ? 'R' : 'L';
            case 'D':
                return clockwise ? 'L' : 'R';
            default:
                return 'R';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        String[] inputs;
        boolean[][] apples = new boolean[n][n];

        for (int i = 0 ; i < k ; i++) {
            inputs = br.readLine().split(" ");
            apples[Integer.parseInt(inputs[0])-1][Integer.parseInt(inputs[1])-1] = true;
        }

        int l = Integer.parseInt(br.readLine());
        MoveCommand[] move_commands = new MoveCommand[l];

        for (int j = 0 ; j < l ; j++) {
            inputs = br.readLine().split(" ");
            move_commands[j] = new MoveCommand(Integer.parseInt(inputs[0]), inputs[1].equals("D"));
        }

        char direction = 'R';
        int nx, ny;
        int ans = 0;
        int move_idx = 0;

        Position now = new Position(0,0);
        Position next;

        Queue<Position> snake = new LinkedList<>();
        snake.offer(new Position(0,0));

        while(true){
            ans++;
            
            nx = (direction == 'D') ? 1 : (direction == 'U') ? -1 : 0;
            ny = (direction == 'R') ? 1 : (direction == 'L') ? -1 : 0;
            next = new Position(now.getX() + nx, now.getY() + ny);
            
            if(next.getX() < 0 || next.getY() < 0 || next.getX() >= n || next.getY() >= n || snake.contains(next)) break;
            snake.offer(next);

            //사과 체크
            if (apples[next.getX()][next.getY()]) {
                apples[next.getX()][next.getY()] = false;
            } else {
                snake.poll();
            }
            //현재 위치 갱신
            now.updatePosition(next.getX(), next.getY());

            // command 체크
            if(move_idx < l && ans == move_commands[move_idx].getTime()){
                direction = rotate(direction, move_commands[move_idx].isClockwise());
                move_idx++;
            }
        }
        System.out.println(ans);
    }
}