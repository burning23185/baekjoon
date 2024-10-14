class Solution {
    private class Position{
        int x;
        int y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private int calDist(int sx, int sy, int tx, int ty){
        int a = sx - tx;
        int b = sy - ty;
        return (a*a) + (b*b);
    }
    public int getMinDistance(Position white, Position target, Position end) {
        int res = Integer.MAX_VALUE;
        // 좌
        if (!(white.y == target.y && white.x >= target.x))
             res = Math.min(res, calDist(white.x, white.y, target.x * (-1), target.y));

        // 우
        if (!(white.y == target.y && white.x <= target.x))
            res = Math.min(res, calDist(white.x, white.y, 2* end.x - target.x, target.y));

        // 상
        if (!(white.x == target.x && white.y <= target.y))
            res = Math.min(res, calDist(white.x, white.y, target.x, 2*end.y - target.y));

        // 하
        if (!(white.x == target.x  && white.y >= target.y))
            res = Math.min(res, calDist(white.x, white.y, target.x, target.y * (-1)));

        return res;
    }

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        Position white = new Position(startX, startY);
        Position end = new Position(m,n);
        for(int i = 0 ; i < balls.length ; i++){
            answer[i] = getMinDistance(white, new Position(balls[i][0], balls[i][1]), end);
        }
        return answer;
    }
}