import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main{
    //n개의 집 m개의 도로 cost
    //사이클을 제외하고 모두 분리하기.
    //분리된 마을은 사이클이어야함.
    //cost의 합이 최소 되도록
    static int [] p;
    static List<node> graph[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        p = new int[n+1];
        for(int i=1; i<=n; i++) {
            p[i] = i; //setting
        }
        PriorityQueue<node> pq = new PriorityQueue<>();
        for(int i=0; i<m; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            pq.add(new node(v1, v2, cost));
        }
        int maxC=0;
        int sum = 0;
        while(!pq.isEmpty()){
            node edge = pq.poll();
            //edge 더하면 사이클 되는지 검사
            int p1 = union_find(edge.n1);
            int p2 = union_find(edge.n2);
            if(p1!=p2){
                union_merge(p1, p2);
                maxC = Math.max(maxC, edge.cost);
                sum += edge.cost;
            }
        }
        System.out.println(sum-maxC);
    }

    private static void union_merge(int p1, int p2) {
        if(p1>p2) p[p2]=p1;
        else p[p1]=p2;
    }

    private static int union_find(int n) {
        if(p[n]==n) return n;
        return union_find(p[n]);
    }


}

class node implements Comparable<node> {
    int n1;
    int n2;
    int cost;
    public node(int n1, int n2, int cost){
        this.n1 = n1;
        this.n2 = n2;
        this.cost = cost;
    }
    @Override
    public int compareTo(node o1){
        return this.cost - o1.cost;
    }
}