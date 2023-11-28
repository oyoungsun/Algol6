import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    static int n;
    static String[] strings;
    static HashMap<Character, Integer> map = new HashMap<>();
    static HashMap<Integer, List<String>> length = new HashMap<>();
    static HashMap<Character, Integer> set = new HashMap<>();

    public static void main(String[] args) {
        //알파벳 1개와 숫자 0-9중 하나 매칭하여
        //N개의 단어가 주어졌을 때, 그 수의 합을 최대로 만드는 프로그램을 작성하시오.
        //알파벳<10, N<8
        //strings중 가장 큰 길이 가진애 -> 9 ...
        //자릿수같은거 2개 이상이면 빈도수 순으로

        //->수정 : 자릿수*횟수 가 가장 큰녀석을 가장 크게 설정
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        strings = new String[n];
        int maxL = 0;
        for (int i = 0; i < n; i++) {
            strings[i] = sc.next();
            maxL = Math.max(strings[i].length(), maxL);
        }
        for (int i = maxL; i > 0; i--) {
            settingSet(i);
        }
        int grant = 9;
//        int realMax = maxL;
//        while (maxL > 0) { //숫자할당
        getMaxDCharactor(maxL, grant, 0);
//            grant = temp;
//            maxL--;
//        }
        //합산
        StringBuilder sb;
        int sum = 0;
        for (String s : strings) {
            sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append(map.get(c));
            }
            sum += Integer.parseInt(sb.toString());
        }
        System.out.println(sum);
    }

    private static int getMaxDCharactor(int maxL, int temp, int realMax) {
        PriorityQueue<charNode> pq = new PriorityQueue<>();
        for (char c : set.keySet()) {
            pq.add(new charNode(c, set.get(c)));
        }
        int grant = 9;
        while (!pq.isEmpty()) {
            charNode now = pq.poll();
            map.put(now.alpha, grant);
            grant--;
        }
        return 0;
    }

    private static void settingSet(int maxLength) {
        for (String s : strings) {
            if (s.length() < maxLength) {
                continue;
            }
            char ch = s.charAt(s.length() - maxLength);
            int dechi = (int) Math.pow(10, maxLength);
            if (set.containsKey(ch)) {
                int sum = set.get(ch);
                set.put(ch, sum + dechi);
            } else {
                set.put(ch, dechi);
            }
        }
    }
}


class charNode implements Comparable<charNode> {
    int sum;
    char alpha;

    public charNode(char alpha, int sum) {
        this.alpha = alpha;
        this.sum = sum;

    }

    @Override
    public int compareTo(charNode o1) {
        return o1.sum - sum; //내림차순
    }
}