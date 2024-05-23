import java.util.*;

class Position{
    private int x;
    private int y;
    private int step;
    
    public Position(int x, int y, int step){
        this.x = x;
        this.y = y;
        this.step = step;
    }

    public Position(int x, int y){
        this.x = x;
        this.y = y;
        this.step = 1;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getStep(){
        return this.step;
    }
}

class Solution {

    public int solution(int[][] maps) {
        int answer = -1;

        Position now;
        Position target = new Position(maps.length-1, maps[0].length-1);
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        Position[] move_way = {new Position(0, 1), new Position(1, 0), new Position(0, -1), new Position(-1, 0)};

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0,0, 1));
        visited[0][0] = true;

        int next_x = 0; 
        int next_y = 0;

        while(!queue.isEmpty()){
            now = queue.poll();

            //캐릭터가 목표 지점에 도달한 경우
            if(now.getX() == target.getX() && now.getY() == target.getY()){
                answer = (answer == -1) ? now.getStep() : (answer < now.getStep() ? answer : now.getStep());
            }

            //동 서 남 북 으로 탐색 시도
            for(Position p : move_way){
                next_x = now.getX() + p.getX();
                next_y = now.getY() + p.getY();

                if(next_x < 0 || next_y < 0 || next_x >= maps.length || next_y >= maps[0].length) continue;

                if(visited[next_x][next_y]) continue;

                if(maps[next_x][next_y] == 0) continue;

                queue.add(new Position(next_x, next_y, now.getStep() + 1));
                visited[next_x][next_y] = true;
            }
        }
        return answer;
    }
}