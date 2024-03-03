import java.util.Arrays;
import java.util.Scanner;

class Main{
    static int N=10;
    static int bit[][] = new int[N][N];
    static int arr[][] = new int[N][N];
    static int dir[][] = new int[][]{{0,1},{1,0},{0,-1},{-1,0}, {0,0}};
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<N; i++){ //전구의 상태를 저장한다.
            String temp = sc.next();
            for(int j=0; j<N; j++)
                if(temp.charAt(j)=='O') arr[i][j]=1;
        }

        int bitN = 1024;
        //비트마스킹 - 가능한 비트 조합 생성
        for(int i=0; i<bitN; ++i){
            //i로 10bit조합 생성
            //i의 1 : 클릭한다 0 : 클릭하지 않는다.
            initArr();
            int count=0;
            //첫번째 줄 조작
            for(int j=1; j<=N; ++j){
                //i의 1개수를 센다.
                //i의 num위치가 1이라면, "클릭"해서 주위를 변경한다.
                int num = bitN >> j;
                if((i&num)>0){
                    count++;
                    click(0, j-1); //0번째 행, j-1번째 열을 클릭한다.
                }
            }
            //2~10행에 반영하기
            for(int row=1; row<N; ++row){
                for(int col=0; col<N; ++col){
                    if(bit[row-1][col]==1){
                        //윗줄 전구가 1이라면, 현재 줄에서만 꺼줄수 있다.
                        count++;
                        click(row, col);
                    }
                }
            }
            //1~10행 검사 -> == 마지막줄만 확인
            if(Arrays.stream(bit[9]).sum()==0)
                min = Math.min(min, count);
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void click(int x, int y) {
        for(int i=0; i<5; i++){
            int nx = x+dir[i][0];
            int ny = y+dir[i][1];
            if(nx<0||ny<0||nx>=N||ny>=N) continue;
            bit[nx][ny] ^= 1;
        }
    }

    private static void initArr() {
        for(int i=0; i<N; i++){
            bit[i] = arr[i].clone();
        }
    }
}