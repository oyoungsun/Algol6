import java.util.*;

class Main {
    static int dir[][] = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static int n, m; //최대크기 50*50 10^3
    static char map[][];
    static int min = Integer.MAX_VALUE;
    static List<int[]> check = new ArrayList<>();
    static int[] start;

    public static void main(String[] args) {
        //s : 1개
        //c : 반드시 방문, 2개  c에 입장시 모두에게 선물을 전달한다.
        //# : 못감
        //. : 갈수있음
        //1번 이동 마다 방향을 바꾼다.

        //수정 -> visit에 이동 횟수가 아닌 C 발견수로 4차원배열 구성하기
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = sc.next().toCharArray();
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'C') {
                    check.add(new int[]{i, j});
                } else if (map[i][j] == 'S') {
                    start = new int[]{i, j};
                }
            }
        }
        boolean visit[][][] = new boolean[4][n][m];
//        for(int i=0; i<4; i++) {
////            visit[i][start[0]+dir[i][0]][ start[1]+dir[i][1]]=true;
////            dfs(new int[]{start[0]+dir[i][0], start[1]+dir[i][1], i, 0, 0}, visit); //x,y,dir,check번호, 방문 수
////            visit[i][start[0]+dir[i][0]][ start[1]+dir[i][1]]=false;
//        }
        bfs();
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

//    private static void dfs(int[] now, boolean[][][] visit) {
//        if (now[3] == 3) {//allFind()
//            min = Math.min(now[4], min);
//            return;
//        }
//        for (int i = 0; i < 4; i++) {
//            if(now[2]==i) continue; //같은방향으로 전진X
//            if(now[4]>=n*m) continue;
//            int nx = now[0] + dir[i][0];
//            int ny = now[1] + dir[i][1];
//            if (nx >= n || ny >= m || nx < 0 || ny < 0) continue;
//            if(visit[i][nx][ny]) continue;
//            if (map[nx][ny]=='#') continue;
//            if (map[nx][ny]=='C') now[3] = isInCheck(nx,ny);
//            visit[i][nx][ny]=true;
//            dfs(new int[]{nx,ny, i, now[3], now[4]+1}, visit);
//            visit[i][nx][ny]=true;
//        }
//    }

    private static void bfs() {
        boolean visit[][][][] = new boolean[5][3][n][m]; //
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<4; i++) {
            q.add(new int[]{start[0], start[1], 4, 0, 0}); //x,y,dir,check번호, 방문 수
        }
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if(map[now[0]][now[1]]=='C') {
                now[3] += isInCheck(now[0], now[1]); //체크리스트에 해당하는 번호를 넣는다.(idx 1, 2)
            }
            if(now[3]==3){//allFind()
                min = Math.min(now[4], min);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                if(now[2]==i) continue; //같은방향으로 전진X
                if(now[4]>=n*m) continue;
                int nx = now[0] + dir[i][0];
                int ny = now[1] + dir[i][1];
                if (nx >= n || ny >= m || nx < 0 || ny < 0) continue;
                if (visit[i][now[3]][nx][ny]) continue; //이미 간곳은 갈 필요x
                if (map[nx][ny]=='#') continue;
                visit[now[2]][now[3]][now[0]][now[1]]=true;
                q.add(new int[]{nx,ny, i, now[3], now[4]+1});
            }
        }
    }

    private static int isInCheck(int x, int y) {
        for(int i=0; i<check.size(); i++){
            int [] temp = check.get(i);
            if(temp[0]==x&&temp[1]==y) return i+1;
        }
        return 0;
    }
}