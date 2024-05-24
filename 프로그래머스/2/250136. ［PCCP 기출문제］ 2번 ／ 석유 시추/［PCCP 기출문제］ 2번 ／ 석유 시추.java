import java.util.*;

class Oil {
    private int total;
    private Set<Integer> positions_y;

    public Oil(){
        this.total = 0;
        this.positions_y = new HashSet<>();          
    }

    public void inputPosition(int x, int y){
        this.total++;
        positions_y.add(y);
    }

    public Set<Integer> getPositionsY(){
        return positions_y;
    }

    public int getTotal(){
        return total;
    }
}

class Solution {
    boolean[][] visited;
    int[][] move_way = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    Map<Integer, Integer> available_oil = new HashMap<>();

    private Oil bfs(int i, int j, int[][] lend){
        Oil oil = new Oil();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});

        visited[i][j] = true;
        oil.inputPosition(i, j);

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int[] way : move_way){

                int[] next = new int[2];

                next[0] = now[0] + way[0];
                next[1] = now[1] + way[1];
                    
                if(next[0] < 0 || next[0] >= lend.length || next[1] < 0 || next[1] >= lend[0].length) continue;

                if(lend[next[0]][next[1]] == 0) continue;

                if(visited[next[0]][next[1]]) continue;

                visited[next[0]][next[1]] = true;
                oil.inputPosition(next[0], next[1]);
                q.add(next);
            }
        }
        return oil;
    }

    public int solution(int[][] land) {
        int answer = 0;
        visited = new boolean[land.length][land[0].length];

        for(int i = 0 ; i < land.length ; i++){
            for(int j = 0 ; j < land[0].length ; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    Oil oil = this.bfs(i, j, land);
                    for(int y : oil.getPositionsY()){
                        available_oil.put(y, oil.getTotal() + (available_oil.containsKey(y) ? available_oil.get(y) : 0));
                    }
                }
            }
        }
        for(int value : available_oil.values()){
            answer = answer > value ? answer : value;
        }
        return answer;
    }
}