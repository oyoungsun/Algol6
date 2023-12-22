import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main{
    static int MOD_MAX = 10000;
    public static void main(String[] args) {//d1,d2,d3,d4
        //D n*=2 & n %= 10000
        //S n-=1, 0-1 = 9999;
        //L d2, d3, d4, d1 한칸씩 앞으로
        //R d4, d1, d2, d3 한칸씩 뒤로

        //L,R적용할 수 있는 경우 : d1,d2,d3,d4를 모두 가지고 있을때
        //D : B가 A의 2배수 일떄
        //S : 그외의 경우
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for(int t=0; t<testcase; t++){
            char[] A = makeCharArray(sc.next());
            char[] B =  makeCharArray(sc.next());
            System.out.println(findCommand(A,B));
        }
    }

    private static char[] makeCharArray(String charArray) {
        char temp[] = new char[4];
        int remain = Integer.parseInt(charArray);
        int d = 1000;
        for(int i=0; i<4; i++) {
            temp[i] = String.valueOf(remain / d).charAt(0);
            remain %= d;
            d /= 10;
        }
        return temp;
    }

    private static int findCommand(final char[] a, final char[] b) {
        String result="";
        //L 또는 R 검사, L3번은 R1번과 같음.
        int isLR = doR(a, b);
        int isD = doD(a,b);

        return isD;
        //return result;
    }

    private static int doD(final char[] a, final char[] b) {
        int aInt = toInt(a);
        int bInt = toInt(b);
        int max = Math.max(aInt, bInt);
        int min = Math.min(aInt, bInt);
        int cnt=0;
        while(max>min){
            min*=2;
            cnt++;
        }
        if(max!=min) return -1;
        return cnt;
    }

    private static int toInt(final char[] array) {
        int sum=0;
        int d = 1000;
        for(int i=0; i<4; i++) {
            sum += (array[i]-'0')*d;
            d /= 10;
        }
        return sum;
    }

    private static int doR(final char[] a, final char[] b) {
        for(int i=0; i<a.length; i++){
            if(a[i]==b[0]) {
                int j;
                for (j = 0; j < b.length; j++) {
                    if(a[((i+j)%b.length)]!=b[j]) break;
                }
                if(j==b.length) return j-i;
            }
        }
        return -1;
    }
}