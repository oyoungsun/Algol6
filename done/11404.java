import java.util.Arrays;
import java.util.Scanner;

class Main{
    static int INF = 987654321;
    static int dist[][];
    public static void main(String[] args) {
        //
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dist =  new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            Arrays.fill(dist[i],INF);
            dist[i][i] = 0;
        }

        int m = sc.nextInt();
        for(int i=0; i<m; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            int c = sc.nextInt();
            dist[s][e] = Math.min(dist[s][e], c);
        }//단방향 그래프

        for(int z=1; z<=n; z++){ //start x, end y, 경유지 z
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(dist[i][j] > dist[i][z]+dist[z][j]){
                        dist[i][j] = dist[i][z]+dist[z][j];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) {
                    dist[i][j] = 0;
                }

                sb.append(dist[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}