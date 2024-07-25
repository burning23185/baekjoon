class Solution {
    private int[][] board;

    private int rotate(int[] query){
        int sx = query[0]-1;
        int sy = query[1]-1;
        int ex = query[2]-1;
        int ey = query[3]-1;

        int buffer = board[sx][ey];
        int min = buffer;

        //우측
        for(int i = ey ; i > sy ; i--) {
            min = Math.min(min,board[sx][i - 1]);
            board[sx][i] = board[sx][i - 1];
        }

        int buffer2 = board[ex][ey];
        min = Math.min(min, buffer2);
        //하단
        for(int i = ex ; i > sx ; i--){
            min = Math.min(min, board[i-1][ey]);
            board[i][ey] = board[i-1][ey];
        }
        board[sx+1][ey] = buffer;
        buffer = board[ex][sy];
        min = Math.min(min, buffer);
        //좌측
        for(int i = sy ; i < ey ; i++){
            min = Math.min(min, board[ex][i+1]);
            board[ex][i] = board[ex][i+1];
        }
        board[ex][ey-1] = buffer2;

        //상단
        for(int i = sx ; i < ex ; i++){
            min = Math.min(min, board[i+1][sy]);
            board[i][sy] = board[i+1][sy];
        }
        board[ex-1][sy] = buffer;
        return min;
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        board = new int[rows][columns];
        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < columns ; j++){
                board[i][j] = columns*i+j+1;
            }
        }
        int[] answer = new int[queries.length];
        for(int i = 0 ; i < queries.length ; i++) answer[i] = rotate(queries[i]);

        return answer;
    }
}