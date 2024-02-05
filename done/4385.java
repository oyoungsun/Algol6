import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
* 100 : 멈춤을 의미한다
2dn : set register(d) = n
3dn : add register(d) += n
4dn은 mul register(d) *= n
5ds는 register(d) = register(s)
6ds는 register(d) += register(s)
7ds는 register(d) *= register(s)
8da는 register(d) = RAM(a)
9sa는 RAM(a) = register(s)
0ds는 register(s) !=0이라면 register(d)의 위치로 이동해라
* */
class Main {
    static int register[] = new int[10];
    static int counter = 0;
    static int MOD = 1000;
    static String[] insts = new String[1001];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        int excuted = 0;
        int i = 0;
        while ((str= br.readLine())!=null){
            insts[i] = str;
            i++;
        }

        String inst = insts[counter];
        while (!isHalt(inst)) {
            interpreter(inst); //명령어 코드 0~9해석
            counter %= MOD;
            if (counter >= 1000) {
                break;
            }
            inst = insts[counter];
            excuted++;
        }
        System.out.println(excuted + 1);
    }

    private static void interpreter(final String inst) {
        //2~9 : ram++
        //0이면 실행함수 위치 바꿔야함
        char code = inst.charAt(0);
        int d = inst.charAt(1) - '0';
        int s = inst.charAt(2) - '0';
        counter++;
        if (code == '0') {//        0ds는 register(s) !=0이라면 register(d)의 위치로 이동해라
            if (register[s] != 0) {
                counter = register[d];
            }
            return;
        }
        switch (code) {
            case '1':
                break;
            case '2': //        2dn : set register(d) = n
                register[d] = s;
                break;
            case '3': //        3dn : add register(d) += n
                register[d] = (register[d] + s) % MOD;
                break;
            case '4': //        4dn은 mul register(d) *= n
                register[d] = (register[d] * s) % MOD;
                break;
            case '5': //        5ds는 register(d) = register(s)
                register[d] = register[s];
                break;
            case '6': //        6ds는 register(d) += register(s)
                register[d] = (register[d] + register[s]) % MOD;
                break;
            case '7': //        7ds는 register(d) *= register(s)
                register[d] = (register[d] * register[s]) % MOD;
                break;
            case '8': //        8da는 register(d) = RAM(a)
                register[d] = Integer.parseInt(insts[register[s]]);
                break;
            case '9': //        9sa는 RAM(a) = register(s)
                insts[register[s]] = String.valueOf(register[d]);
                break;
            default:
                break;
        }
        register[d] %= MOD;
        counter %= MOD;
        return;


    }

    private static boolean isHalt(final String inst) {
        return inst.equals("100");
    }
}