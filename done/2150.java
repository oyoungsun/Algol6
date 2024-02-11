import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Main{
    static Stack<Integer> finish = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        List<Integer>[] graph = new ArrayList[n+1];
        List<Integer>[] graphr = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            graph[i] = new ArrayList<>();
            graphr[i] = new ArrayList<>();

        }
        for(int i=0; i<e; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph[v1].add(v2);
            graphr[v2].add(v1);

        }
        //start, finish time  : dfs, start=1로 임의지정
        boolean [] visit = new boolean[n+1];
        for(int i=1; i<=n; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            setFinishDfs(i, graph, visit);
        }
        //finish 순으로 정렬-stack, 그래프 뒤집기(graphr)
        visit = new boolean[n+1];
        List<List<Integer>> result = new ArrayList<>();
        while(!finish.isEmpty()){
            int maxF =finish.pop();
            //dfs(maxF)
            if(visit[maxF]) continue;
            visit[maxF]=true;
            List<Integer> order = new ArrayList<>();
            printDfs(maxF, graphr, visit, order);
            Collections.sort(order);
            result.add(order);
        }
        //result 정렬하기
        Collections.sort(result, (o1,o2)-> o1.get(0)-o2.get(0));
        System.out.println(result.size());
        for(List<Integer> order : result){
            for (int j : order) {
                System.out.print(j + " ");
            }
            System.out.println(-1);
        }
    }

    private static void setFinishDfs(int start,  List<Integer>[] graph,  boolean[] visit) {
        for(int i : graph[start]){
            if(visit[i]) continue;
            visit[i]=true;
            setFinishDfs(i, graph, visit);
        }
        finish.push(start);
    }

    private static void printDfs(int start, List<Integer>[] graph, boolean[] visit,  List<Integer> order) {
        order.add(start);
        for(int i : graph[start]){
            if(visit[i]) continue;
            visit[i]=true;
            printDfs(i, graph, visit, order);
        }

    }
}
