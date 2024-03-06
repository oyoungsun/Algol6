import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main{
    //문제 :
    // n명을 한명 이상인 두 팀으로 분배
    //능력치 Si,j = sij+sji
    //두 팀의 능력치를 최소화 하도록 저장

    //s를 정렬한다음에 투포인트 하면?
    // -> 투포인터는 하나의 배열(순서 고정)에 대해서만 연산 가능.
    /*비트마스킹으로, 선수 1~n번 까지의 조합을 bit 배열로 표현
    -> O(2^n)
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = Integer.MAX_VALUE;
        //max : 20*20*100
        int s[][] = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                s[i][j] = sc.nextInt();
        int bits=1;
        for(int i=0; i<n; i++) bits*=2;

        for(int i=bits; i>=0; i--){ //0~2^n까지 실행한다.
            boolean start[] = new boolean[n];
            boolean link[] = new boolean[n];
            Arrays.fill(link, true);
            for(int j=1; j<=n; j++){
                //(xor)j번째 결과가 1이라면, start에 s 더함.
                //0이라면 link에 s 더함
                int num = bits >> j;
                if( ((bits>>j)&i)>0 ){
                    //1111>>0 &= 1
                    //1111>>1 = 0111 & 1111 = 1
                    //1111>>2 = 0011 & = 1
                    //1111>>3 = 0001 &=1
                    start[j-1]=true;
                    link[j-1]=false;
                }
            }
            //모든 s합한 값에서 빼면됨...
            int result = count(start, s, new int[2], 0, 0) -  count(link, s, new int[2], 0, 0);
            System.out.println(result);
            min = Math.min(min, Math.abs(result));
        }
        System.out.println(min);
    }
 //모든 조합의 s합을 구한다.
    private static int count(boolean[] start, int[][] s, int mem[], int depth, int i) {
        if(depth==2){
//            System.out.println(mem[0]+" "+mem[1]);
            return s[mem[0]][mem[1]]+s[mem[1]][mem[0]];
        }
        int sum=0;
        for(int k=i; k<start.length; k++){
            if(start[k]){
                mem[depth]=k;
                sum+= count(start, s, mem, depth+1,k+1);
            }
        }
        return sum;
    }
}