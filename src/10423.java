import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main{
    //n개 도시 m개의 edge 발전소 소유 k
    //한도시 1발전기 이상 연결되어야함
    //최소 비용으로
    //아이디어 : mst 정렬 - union find하다가
    //모두 연결여부를 어떻게 알지?
    //부모가 발전기중 하나면 더이상 연결할 필요x
    static int p[];
    static PriorityQueue<edge> edgs = new PriorityQueue<>();
    static HashSet<Integer> elec;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        p = new int[n+1];
        elec = new HashSet<>();
        for(int i=0; i<k; i++) elec.add(sc.nextInt());

        for(int i=0; i<m; i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int cost = sc.nextInt();
            edgs.add(new edge(n1,n2,cost));
        }
        initUF(n);
        int result=0;

        while(!edgs.isEmpty()&&!isDone(p, n)){
            edge now = edgs.poll();
            if(!isPisE(now.v1) || !isPisE(now.v2)){
                result += merge(now.v1, now.v2, now.cost);
            }

        }
        System.out.println(result);
    }

    private static int merge(int v1, int v2, int cost) {
        //부모가 같은지 검사
        int p1 = findP(v1);
        int p2 = findP(v2);
        if(p1==p2) return 0;
        //다르다면 기준에 따라 병합
        //1. 둘다 발전소인 경우 -> 병합할 필요x
        if(isPisE(p1)&&isPisE(p2)) return 0;
        if(isPisE(p1)) {
            p[p2]=p1;
            return cost;
        } //2. 둘 중 하나만 발전소 -> 해당 발전소를 p로 지정
        if(isPisE(p2)){
            p[p1]=p2;
            return cost;
        }
        //3. 둘다 발전소x -> 둘 중 작은게 p가 됨
        if(p1>p2) p[p1]=p2;
        else p[p2]=p1;
        return cost;

    }

    private static int findP(int v1) {
        if(p[v1]==v1) return v1;
        else return findP(p[v1]);
    }

    private static boolean isDone(int[] p, int n) {
        for(int i=1; i<=n; i++){
            if(!isPisE(p[i])) return false;
        }
        //모두 발전소와 연결된 경우
        return true;
    }

    private static boolean isPisE(int pnode) {
        return elec.contains(pnode);
    }

    private static void initUF(int n) {
        for(int i=1; i<=n; i++) p[i]=i;
    }

}
class edge implements Comparable<edge> {
    int v1;
    int v2;
    int cost;

    public edge(int v1, int v2, int cost){
        this.v1=v1;
        this.v2 = v2;
        this.cost =cost;
    }
    @Override
    public int compareTo(edge o1){
        return this.cost - o1.cost;
    }
}