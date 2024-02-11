import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] coin = new int[n+1];
        int [] dp = new int[k+1];
        for(int i=1; i<=n; i++){
            coin[i] = sc.nextInt();
        }
        dp[1]=1;
        //Arrays.sort(coin);
        //초기값 세팅하기
        for (int j = 1; j <= n; j++) {
            for(int i=1; i<=k; i++) {
                // 현재 i에서 코인 j 로 뺄수있는 경우
                if (i - coin[j] > 0) {
                    dp[i] += dp[i - coin[j]];
                }
                //뺄수 없는 경우
            }
        }
        System.out.println(dp[k]);
    }
}