import java.util.HashSet;
import java.util.Objects;

public class Solution {
    private long min_x= Long.MAX_VALUE, min_y= Long.MAX_VALUE;
    private long max_x= Long.MIN_VALUE, max_y= Long.MIN_VALUE;

    public class Point{
        long x;
        long y;
        public Point(long x, long y){
            this.x= x;
            this.y= y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public String[] solution(int[][] line) {
        HashSet<Point> points= new HashSet<>();

        //x= (BF-CE)/(AE-BD)
        //y= (CD-AF)/(AE-BD)
        // cal point
        long x, y;
        for(int i=0; i<line.length-1; i++){
            long a= line[i][0];
            long b= line[i][1];
            long c= line[i][2];
            for(int j=i+1; j<line.length; j++){
                int d= line[j][0];
                int e= line[j][1];
                int f= line[j][2];

                long denom= a*e-b*d;
                if(denom==0) continue;

                long mol_x= b*f-c*e;
                if(mol_x % denom!=0) continue;

                long mol_y= a*f-c*d;
                if(mol_y%denom!=0) continue;

                x = mol_x / denom;
                y = mol_y / denom;
                points.add(new Point(x, y));

                min_x= Math.min(min_x, x);
                min_y= Math.min(min_y, y);
                max_x= Math.max(max_x, x);
                max_y= Math.max(max_y, y);
            } // for
        } // for

        //make star
        int height = (int) (max_y - min_y) + 1;
        int width = (int) (max_x - min_x) + 1;

        String[] answer = new String[height];
        StringBuilder sb= new StringBuilder();
        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < width ; j++){
                sb.append(points.contains(new Point(j+min_x,i+min_y)) ? "*" : ".");
            }
            answer[i] = sb.toString();
            sb.setLength(0);
        }
        return answer;
    }
}