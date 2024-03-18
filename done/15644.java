import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main{
    static int n, m;
    static int array[][];
    static int r[] = new int[2];
    static int b[] = new int[2];

    //LRUD
    static int dir[][] = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
    static int ox, oy;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        //setting
        for(int i=0; i<n; i++){
            String temp= sc.next();
            for(int j=0; j<m; j++){
                if(temp.charAt(j)=='#') array[i][j]=0;
                else if (temp.charAt(j)=='.')array[i][j]=1;
                else if(temp.charAt(j)=='B') {
                    array[i][j]=1;
                    b[0]=i; b[1]=j;
                }else if(temp.charAt(j)=='A'){
                    array[i][j]=1;
                    r[0]=i; r[1]=j;
                }else {
                    array[i][j]=1;
                    ox=i; oy=j;
                }
            }
        }
        //최소 .. -> bfs로 탐색해야함.
        position result = bfs();
        System.out.println(result.cnt);
        System.out.println(result.getList());
    }

    private static position bfs() {
        Queue<position> q = new LinkedList<>();
        q.add(new position(r, b, 0));
        while(!q.isEmpty()){
            position now = q.poll();
            for(int i=0; i<4; i++){
                //LRUD 한번씩 굴려서 R, B의 위치를 새로 구함.
                position next = roll(now, dir[i][0], dir[i][1]);
                //next가 now와 같으면 움직이는 의미 없음.
                if(now.equalTo(next)) continue;
                if(next.isOut()) return next;
                q.add(next);
            }
        }
    }
}
class position{
    int r[];
    int b[];
    int cnt ; // 기울인 횟수
    public position(int [] r, int []b, int cnt){
        this.r=r;
        this.b=b;
        this.cnt=cnt;
    }
    public boolean equalTo(position o2){
        return Arrays.equals(this.r, o2.r) && Arrays.equals(this.b, o2.b);
    }

    public String getList() {
    }
}