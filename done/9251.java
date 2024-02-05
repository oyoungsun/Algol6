import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        int dp[][] = new int[1000][1000];
        Scanner sc = new Scanner(System.in);
        String sec = sc.next();
        String fir = sc.next();
        if(fir.charAt(0)==sec.charAt(0)) dp[0][0]=1;
        for(int i=0; i<sec.length(); i++){
            for(int j=0; j<fir.length(); j++){
                if(i==0&&j==0) continue;
                if(fir.charAt(j)==sec.charAt(i)) {
                    //현재가 같은 경우
                    if(i==0){
                        dp[0][j]=1;
                    }
                    else if (j == 0) {
                        dp[i][0] = 1;
                    }else{
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
                else{
                    if(i==0){
                        dp[i][j]=dp[0][j-1];
                    }
                    else if(j==0){
                        dp[i][j] = dp[i-1][0];
                    }
                    else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[sec.length()-1][fir.length()-1]);
    }
}